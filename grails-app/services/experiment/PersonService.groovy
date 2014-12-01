package experiment

class PersonService {

    Person createPet(String id, int age, String gender,
                     ArrayList<String> listOfTrueWordsRecalled, ArrayList<String> listOfFalseWordsRecalled,
                     int numberOfTrueWordsRecalled, boolean didRecallCriticalLureInListOfWords, boolean didRecallCriticalLureInYesOrNoQuestions) {
        Person person = new Person(id: id, age: age, String: gender,
                listOfTrueWordsRecalled: listOfTrueWordsRecalled, listOfFalseWordsRecalled: listOfFalseWordsRecalled,
                numberOfTrueWordsRecalled: numberOfTrueWordsRecalled, didRecallCriticalLureInListOfWords: didRecallCriticalLureInListOfWords, didRecallCriticalLureInYesOrNoQuestions: didRecallCriticalLureInYesOrNoQuestions);
        person.save();
        return person;
    }

}
