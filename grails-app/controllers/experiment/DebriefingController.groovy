package experiment

class DebriefingController {

    def personService;
    def cookieService;


    def fromRecall() {
        String id = cookieService.getCookie("sessionID");
        int age = Integer.valueOf(cookieService.getCookie("age"));
        String gender = cookieService.getCookie("gender");
        String studyType = cookieService.getCookie("studyType");

        Set<String> recalledWords = params.recalledWords;
        ArrayList<String> listOfTrueWordsRecalled = new ArrayList<>(personService.buildWordsCorrectlyRecalledList(recalledWords.toList()));
        ArrayList<String> listOfFalseWordsRecalled = new ArrayList<>(personService.buildWordsIncorrectlyRecalledList(recalledWords.toList()));
        int numberOfTrueWordsRecalled = listOfTrueWordsRecalled.size();
        boolean didRecallCriticalLureInFreeRecall = true;

        personService.createPerson(id, age, gender, studyType, listOfTrueWordsRecalled, listOfFalseWordsRecalled, numberOfTrueWordsRecalled, didRecallCriticalLureInFreeRecall);


        System.out.println(Person.list().size());
        render(view: "index", model: [people: Person.list()]);
    }
}
