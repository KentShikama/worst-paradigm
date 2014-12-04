package experiment

class PersonService {

    List<String> correctWordList = ["shoe","hand","toe","kick","sandals","soccer","yard","walk","ankle","arm","boot","inch","sock","smell","mouth"].toList();

    Person createPerson(String address, int age, String gender, String studyType,
                     ArrayList<String> listOfTrueWordsRecalled, ArrayList<String> listOfFalseWordsRecalled,
                     int numberOfTrueWordsRecalled, boolean didRecallCriticalLureInFreeRecall) {
        Person person = new Person(address: address, age: age, gender: gender, studyType: studyType,
                listOfTrueWordsRecalled: listOfTrueWordsRecalled, listOfFalseWordsRecalled: listOfFalseWordsRecalled,
                numberOfTrueWordsRecalled: numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall: didRecallCriticalLureInFreeRecall);
        return person;
    }

    Person createPerson(String address, int age, String gender, String studyType,
                        ArrayList<String> listOfTrueWordsRecalled, ArrayList<String> listOfFalseWordsRecalled,
                        int numberOfTrueWordsRecalled, boolean didRecallCriticalLureInFreeRecall, boolean didRecallCriticalLureInRecognition) {
        Person person = new Person(address: address, age: age, gender: gender, studyType: studyType,
                listOfTrueWordsRecalled: listOfTrueWordsRecalled, listOfFalseWordsRecalled: listOfFalseWordsRecalled,
                numberOfTrueWordsRecalled: numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall: didRecallCriticalLureInFreeRecall, didRecallCriticalLureInRecognition: didRecallCriticalLureInRecognition);
        return person;
    }

    List<Item> createItems() {
        List<Item> itemList = new ArrayList<>();
        for (String word: correctWordList) {
            Item item = new Item(word: word, lineDrawingURL: word + "-linedrawing.jpg", photographURL: word + "-photograph.jpg");
            itemList.add(item);
        }
        return itemList;
    }

    List<String> buildWordsCorrectlyRecalledList(List<String> recalledWordList) {
        List<String> wordsCorrectlyRecalled = new ArrayList<String>();
        Map<String, List<String>> interpretationMap = buildInterpretationMap();
        for (String correctWord : correctWordList) {
            List<String> interpretations = interpretationMap.get(correctWord);
            for (String recalledWord : recalledWordList) {
                if (recalledWord.contains(correctWord)) {
                    wordsCorrectlyRecalled.add(recalledWord);
                }
                if (interpretations != null && !interpretations.isEmpty()) {
                    for (String interpretation : interpretations) {
                        if (recalledWord.contains(interpretation)) {
                            wordsCorrectlyRecalled.add(recalledWord);
                        }
                    }
                }
            }
        }
        return wordsCorrectlyRecalled;
    }

    List<String> buildWordsIncorrectlyRecalledList(List<String> recalledWordList) {
        List<String> wordsIncorrectlyRecalled = new ArrayList<String>();
        Map<String, List<String>> interpretationMap = buildInterpretationMap();
        for (String recalledWord : recalledWordList) {
            boolean isCorrectWord = false;
            for (String correctWord : correctWordList) {
                List<String> interpretations = interpretationMap.get(correctWord);
                if (recalledWord.contains(correctWord)) {
                    isCorrectWord = true;
                }
                if (interpretations != null && !interpretations.isEmpty()) {
                    for (String interpretation : interpretations) {
                        if (recalledWord.contains(interpretation)) {
                            isCorrectWord = true;
                        }
                    }
                }
            }
            if (!isCorrectWord) {
                wordsIncorrectlyRecalled.add(recalledWord);
            }
        }
        return wordsIncorrectlyRecalled;
    }

    int getNumberOfLineDrawingParticipantsWhoRecalledOrRecognizedLureWord(List<Person> personList) {
        int count = 0;
        for (Person person : personList) {
            if (person.studyType.equals("lineDrawings")) {
                if (person.didRecallCriticalLureInFreeRecall || person.didRecallCriticalLureInRecognition) {
                    count++;
                }
            }
        }
        return count;
    }

    int getNumberOfPhotographParticipantsWhoRecalledOrRecognizedLureWord(List<Person> personList) {
        int count = 0;
        for (Person person : personList) {
            if (person.studyType.equals("photographs")) {
                if (person.didRecallCriticalLureInFreeRecall || person.didRecallCriticalLureInRecognition) {
                    count++;
                }
            }
        }
        return count;
    }

    private Map<String, List<String>> buildInterpretationMap() {
        Map<String, List<String>> interpretationList = new HashMap<>();
        interpretationList.put("arm", ["flex", "muscle"].toList());
        interpretationList.put("boot", ["shoes","rainboot"].toList());
        interpretationList.put("hand", ["palm", "wave"].toList());
        interpretationList.put("inch", ["paper clip","measure","ruler"].toList());
        interpretationList.put("kick", ["soccer","shoot","goal","shot"].toList());
        interpretationList.put("mouth", ["talk", "sing","lips","yawn","tongue"].toList());
        interpretationList.put("shoe", ["sneaker"].toList());
        interpretationList.put("sandals", ["flip flop","shoes"].toList());
        interpretationList.put("smell", ["sniff","flower","nose"].toList());
        interpretationList.put("sock", ["stocking"].toList());
        interpretationList.put("toe", ["big toe"].toList());
        interpretationList.put("walk", ["skate, exercise","friends","guy","moving"].toList());
        interpretationList.put("yard", ["meter"].toList());
        return interpretationList;
    }
}
