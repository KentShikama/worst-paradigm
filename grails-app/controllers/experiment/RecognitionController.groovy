package experiment

class RecognitionController {

    private static final int SHORTENED_LIST_LENGTH = 8;

    def grailsApplication;

    def index() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService");
        if (sessionScopedService.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            ArrayList recalledWordList = sessionScopedService.recalledWords;
            sessionScopedService.recognitionWordList = createRecognitionWordList(recalledWordList);
            ArrayList recognitionWordList = sessionScopedService.recognitionWordList;
            String typeOfImage = sessionScopedService.studyType;
            if (typeOfImage.equals("lineDrawing")) {
                typeOfImage = "line drawing";
            } else {
                typeOfImage = "photograph";
            }
            return [typeOfImage: typeOfImage, word: recognitionWordList.get(0)];
        }
    }

    def yes() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService");
        if (sessionScopedService.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            ArrayList<String> recognitionWordList = (ArrayList<String>) sessionScopedService.recognitionWordList;
            String wordShown = recognitionWordList.get(0);
            if (wordShown.equals("foot")) {
                sessionScopedService.didRecallCriticalLureInRecognition = true;
                redirect(controller: 'debriefing', action: 'index');
                return;
            } else {
                recognitionWordList.remove(0);
                String typeOfImage = sessionScopedService.studyType;
                if (typeOfImage.equals("lineDrawing")) {
                    typeOfImage = "line drawing";
                } else {
                    typeOfImage = "photograph";
                }
                render(view: 'index', model: [typeOfImage: typeOfImage, word: sessionScopedService.recognitionWordList.get(0)]);
            }
        }
    }

    def no() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService");
        if (sessionScopedService.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            ArrayList<String> recognitionWordList = sessionScopedService.recognitionWordList;
            String wordShown = recognitionWordList.get(0);
            if (wordShown.equals("foot")) {
                sessionScopedService.didRecallCriticalLureInRecognition = false;
                redirect(controller: 'debriefing', action: 'index');
                return;
            } else {
                recognitionWordList.remove(0);
                String typeOfImage = sessionScopedService.studyType;
                if (typeOfImage.equals("lineDrawing")) {
                    typeOfImage = "line drawing";
                } else {
                    typeOfImage = "photograph";
                }
                render(view: 'index', model: [typeOfImage: typeOfImage, word: sessionScopedService.recognitionWordList.get(0)]);
            }
        }
    }

    ArrayList<String> createRecognitionWordList(ArrayList<String> recalledWordList) {
        List<String> relatedWrongWordList = ["finger", "nail", "nose", "mile", "elbow", "leg", "knee", "calf", "cleats", "lips", "laces", "tights", "football", "rugby", "heel", "sole", "sweaty", "velcro", "throw", "catch"].toList();
        List<String> correctWordList = ["shoe", "hand", "toe", "kick", "sandal", "soccer", "yard", "walk", "ankle", "arm", "boot", "inch", "sock", "smell", "mouth"].toList();
        List<String> wordsNotRecalledList = buildWordsNotRecalledList(correctWordList, recalledWordList.toList());

        Collections.shuffle(relatedWrongWordList);
        Collections.shuffle(wordsNotRecalledList);

        ArrayList<String> combinedList = buildCombinedList(relatedWrongWordList, wordsNotRecalledList, correctWordList)
        return combinedList;
    }

    private ArrayList<String> buildCombinedList(List<String> relatedWrongWordList, List<String> wordsNotRecalledList, List<String> correctWordList) {
        List<String> combinedList = new ArrayList<>();
        combinedList.addAll(relatedWrongWordList.subList(0, 4));
        if (wordsNotRecalledList.size() < 4) {
            combinedList.addAll(wordsNotRecalledList.subList(0, 4));
        } else {
            combinedList.addAll(correctWordList.subList(0, 4));
        }
        Collections.shuffle(combinedList);
        int positionOfFoot = calculatePositionOfFoot()
        combinedList.add(positionOfFoot, "foot");
        return combinedList;
    }

    private int calculatePositionOfFoot() {
        int positionOfFoot = (int) (Math.random() * (SHORTENED_LIST_LENGTH));
        if (positionOfFoot < 4) {
            positionOfFoot += 4;
        }
        return positionOfFoot;
    }

    private List<String> buildWordsNotRecalledList(List<String> correctWordList, List<String> recalledWordList) {
        List<String> wordsNotRecalledList = new ArrayList<String>();
        Map<String, List<String>> interpretationList = buildInterpretationMap();
        for (String word : correctWordList) {
            boolean didRecallWord = false;
            List<String> interpretations = interpretationList.get(word);
            for (String recalledWord : recalledWordList) {
                if (recalledWord.contains(word)) {
                    didRecallWord = true;
                }
                if (interpretations != null && !interpretations.isEmpty()) {
                    for (String interpretation : interpretations) {
                        if (recalledWord.contains(interpretation)) {
                            didRecallWord = true;
                        }
                    }
                }
            }
            if (!didRecallWord) {
                wordsNotRecalledList.add(word);
            }
        }
        return wordsNotRecalledList;
    }

    private Map<String, List<String>> buildInterpretationMap() {
        Map<String, List<String>> interpretationList = new HashMap<>();
        interpretationList.put("arm", ["flexing", "muscle"].toList());
        interpretationList.put("boot", ["boots", "rainboot"].toList());
        interpretationList.put("hand", ["palm", "wave"].toList());
        interpretationList.put("inch", ["ruler"].toList());
        interpretationList.put("mouth", ["talk", "sing"].toList());
        interpretationList.put("smell", ["sniff"].toList());
        interpretationList.put("toe", ["big toe"].toList());
        interpretationList.put("walk", ["skate, exercise"].toList());
        return interpretationList;
    }
}
