package experiment

class RecognitionController {

    private static final int SHORTENED_LIST_LENGTH = 8;

    def sessionScopedServiceProxy;

    def index() {
        if (sessionScopedServiceProxy.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            Set recalledWordList = sessionScopedServiceProxy.recalledWords;
            sessionScopedServiceProxy.recognitionWordList = createRecognitionWordList(recalledWordList);
            return [word: sessionScopedServiceProxy.recognitionWordList.get(0)];
        }
    }

    def yes() {
        if (sessionScopedServiceProxy.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            List<String> recognitionWordList = sessionScopedServiceProxy.recognitionWordList;
            String wordShown = recognitionWordList.get(0);
            if (wordShown.equals("foot")) {
                sessionScopedServiceProxy.didRecallCriticalLureInRecognition = true;
            } else {
                sessionScopedServiceProxy.recognitionWordList = recognitionWordList.remove(0);
                render(view: 'index', model: [word: sessionScopedServiceProxy.recognitionWordList.get(0)]);
            }
        }
    }

    def no() {
        if (sessionScopedServiceProxy.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            List<String> recognitionWordList = sessionScopedServiceProxy.recognitionWordList;
            String wordShown = recognitionWordList.get(0);
            if (wordShown.equals("foot")) {
                sessionScopedServiceProxy.didRecallCriticalLureInRecognition = false;
                redirect(controller: 'distraction', action: 'index');
            } else {
                sessionScopedServiceProxy.recognitionWordList = recognitionWordList.remove(0);
                render(view: 'index', model: [word: sessionScopedServiceProxy.recognitionWordList.get(0)]);
            }
        }
    }

    Set createRecognitionWordList(Set recalledWordList) {
        List<String> relatedWrongWordList = ["finger", "nail", "nose", "mile", "elbow", "leg", "knee", "calf", "flip flops", "cleats", "lips", "laces", "tights", "football", "rugby", "heel", "sole", "sweaty", "velcro", "throw", "catch"].toList();
        List<String> correctWordList = ["shoe", "hand", "toe", "kick", "sandals", "soccer", "yard", "walk", "ankle", "arm", "boot", "inch", "sock", "smell", "mouth"].toList();
        List<String> wordsNotRecalledList = buildWordsNotRecalledList(correctWordList, recalledWordList.toList());

        Collections.shuffle(relatedWrongWordList);
        Collections.shuffle(wordsNotRecalledList);

        ArrayList<String> combinedList = buildCombinedList(relatedWrongWordList, wordsNotRecalledList, correctWordList)
        return new TreeSet(combinedList);
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
        for (String word : correctWordList) {
            boolean didRecallWord = false;
            for (String recalledWord : recalledWordList) {
                if (recalledWord.equals(word)) {
                    didRecallWord = true;
                }
            }
            if (!didRecallWord) {
                wordsNotRecalledList.add(word);
            }
        }
        return wordsNotRecalledList;
    }
}
