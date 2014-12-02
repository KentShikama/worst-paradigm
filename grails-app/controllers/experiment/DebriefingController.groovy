package experiment

class DebriefingController {

    def personService;
    def grailsApplication;
    
    def index() {
        String id = grailsApplication.mainContext.getBean("sessionScopedService").id;
        int age = grailsApplication.mainContext.getBean("sessionScopedService").age;
        String gender = grailsApplication.mainContext.getBean("sessionScopedService").gender;
        String studyType = grailsApplication.mainContext.getBean("sessionScopedService").studyType;

        Set<String> recalledWords = grailsApplication.mainContext.getBean("sessionScopedService").recalledWords;
        ArrayList<String> listOfTrueWordsRecalled = new ArrayList<>(personService.buildWordsCorrectlyRecalledList(recalledWords.toList()));
        ArrayList<String> listOfFalseWordsRecalled = new ArrayList<>(personService.buildWordsIncorrectlyRecalledList(recalledWords.toList()));
        int numberOfTrueWordsRecalled = listOfTrueWordsRecalled.size();

        boolean didRecallCriticalLureInFreeRecall = grailsApplication.mainContext.getBean("sessionScopedService").didRecallCriticalLureInFreeRecall;

        Person you;
        if (didRecallCriticalLureInFreeRecall) {
            you = personService.createPerson(id, age, gender, studyType, listOfTrueWordsRecalled, listOfFalseWordsRecalled, numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall);
        } else {
            boolean didRecallCriticalLureInRecognition = grailsApplication.mainContext.getBean("sessionScopedService").didRecallCriticalLureInRecognition;
            you = personService.createPerson(id, age, gender, studyType, listOfTrueWordsRecalled, listOfFalseWordsRecalled, numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall, didRecallCriticalLureInRecognition);
        }
        if (!grailsApplication.mainContext.getBean("sessionScopedService").finished) {
            you.save(flush: true, failOnError: true);
            grailsApplication.mainContext.getBean("sessionScopedService").finished = true;
        }
        render(view: "index", model: [people: Person.list(), you: you]);
    }
}
