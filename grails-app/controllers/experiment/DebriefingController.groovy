package experiment

class DebriefingController {

    def personService;
    def sessionScopedServiceProxy;

    def index() {
        String id = sessionScopedServiceProxy.id;
        int age = sessionScopedServiceProxy.age;
        String gender = sessionScopedServiceProxy.gender;
        String studyType = sessionScopedServiceProxy.studyType;

        Set<String> recalledWords = sessionScopedServiceProxy.recalledWords;
        ArrayList<String> listOfTrueWordsRecalled = new ArrayList<>(personService.buildWordsCorrectlyRecalledList(recalledWords.toList()));
        ArrayList<String> listOfFalseWordsRecalled = new ArrayList<>(personService.buildWordsIncorrectlyRecalledList(recalledWords.toList()));
        int numberOfTrueWordsRecalled = listOfTrueWordsRecalled.size();

        boolean didRecallCriticalLureInFreeRecall = sessionScopedServiceProxy.didRecallCriticalLureInFreeRecall;

        Person you;
        if (didRecallCriticalLureInFreeRecall) {
            you = personService.createPerson(id, age, gender, studyType, listOfTrueWordsRecalled, listOfFalseWordsRecalled, numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall);
        } else {
            boolean didRecallCriticalLureInRecognition = sessionScopedServiceProxy.didRecallCriticalLureInRecognition;
            you = personService.createPerson(id, age, gender, studyType, listOfTrueWordsRecalled, listOfFalseWordsRecalled, numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall, didRecallCriticalLureInRecognition);
        }

        sessionScopedServiceProxy.finished = true;

        render(view: "index", model: [people: Person.list(), you: you]);
    }
}
