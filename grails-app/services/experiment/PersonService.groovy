package experiment

class PersonService {

    List<String> correctWordList = ["shoe","hand","toe","kick","sandals","soccer","yard","walk","ankle","arm","boot","inch","sock","smell","mouth"].toList();

    Person createPerson(String id, int age, String gender, String studyType,
                     ArrayList<String> listOfTrueWordsRecalled, ArrayList<String> listOfFalseWordsRecalled,
                     int numberOfTrueWordsRecalled, boolean didRecallCriticalLureInFreeRecall) {
        Person person = new Person(id: id, age: age, gender: gender, studyType: studyType,
                listOfTrueWordsRecalled: listOfTrueWordsRecalled, listOfFalseWordsRecalled: listOfFalseWordsRecalled,
                numberOfTrueWordsRecalled: numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall: didRecallCriticalLureInFreeRecall);
        return person;
    }

    Person createPerson(String id, int age, String gender, String studyType,
                        ArrayList<String> listOfTrueWordsRecalled, ArrayList<String> listOfFalseWordsRecalled,
                        int numberOfTrueWordsRecalled, boolean didRecallCriticalLureInFreeRecall, boolean didRecallCriticalLureInRecognition) {
        Person person = new Person(id: id, age: age, gender: gender, studyType: studyType,
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
        for (String word : correctWordList) {
            for (String recalledWord : recalledWordList) {
                if (recalledWord.equals(word)) {
                    wordsCorrectlyRecalled.add(word);
                }
            }
        }
        return wordsCorrectlyRecalled;
    }

    List<String> buildWordsIncorrectlyRecalledList(List<String> recalledWordList) {
        List<String> wordsIncorrectlyRecalled = new ArrayList<String>();
        for (String recalledWord : recalledWordList) {
            boolean isCorrectWord = false;
            for (String correctWord : correctWordList) {
                if (recalledWord.equals(correctWord)) {
                    isCorrectWord = true;
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
}
