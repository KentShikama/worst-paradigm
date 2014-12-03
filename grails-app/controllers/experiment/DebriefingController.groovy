package experiment

class DebriefingController {

    def personService;
    def grailsApplication;
    def grailsResourceLocator;

    def index() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService");

        String id = sessionScopedService.id;
        int age = sessionScopedService.age;
        String gender = sessionScopedService.gender;
        String studyType = sessionScopedService.studyType;

        Set<String> recalledWords = sessionScopedService.recalledWords;
        ArrayList<String> listOfTrueWordsRecalled = new ArrayList<>(personService.buildWordsCorrectlyRecalledList(recalledWords.toList()));
        ArrayList<String> listOfFalseWordsRecalled = new ArrayList<>(personService.buildWordsIncorrectlyRecalledList(recalledWords.toList()));
        int numberOfTrueWordsRecalled = listOfTrueWordsRecalled.size();

        boolean didRecallCriticalLureInFreeRecall = sessionScopedService.didRecallCriticalLureInFreeRecall;

        Person you;
        if (didRecallCriticalLureInFreeRecall) {
            you = personService.createPerson(id, age, gender, studyType, listOfTrueWordsRecalled, listOfFalseWordsRecalled, numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall);
        } else {
            boolean didRecallCriticalLureInRecognition = sessionScopedService.didRecallCriticalLureInRecognition;
            you = personService.createPerson(id, age, gender, studyType, listOfTrueWordsRecalled, listOfFalseWordsRecalled, numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall, didRecallCriticalLureInRecognition);
        }
        if (!sessionScopedService.finished) {
            you.save();
            sessionScopedService.finished = true;
        }

        int lineDrawingNumber = personService.getNumberOfLineDrawingParticipantsWhoRecalledOrRecognizedLureWord(Person.list());
        int photographNumber = personService.getNumberOfPhotographParticipantsWhoRecalledOrRecognizedLureWord(Person.list());
        int numberOfParticipants = Person.list().size();

        render(view: "index", model: [people: Person.list(), you: you, lineDrawingNumber: lineDrawingNumber, photographNumber: photographNumber, numberOfParticipants: numberOfParticipants]);
    }

    def substitute() {
        File file = grailsResourceLocator.findResourceForURI('pdf/identification.pdf').file;
        System.out.println(file.lastModified());
        if (file.exists()) {
            response.setContentType("application/octet-stream")
            response.setHeader("Content-disposition", "filename=${file.name}")
            response.outputStream << file.bytes
        }
        redirect(view: 'index');
    }
}
