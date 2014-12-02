package experiment;

class StartController {

    def grailsApplication;

    def index() {
        if (grailsApplication.mainContext.getBean("sessionScopedService").finished) {
            redirect(controller: 'debriefing', action: 'index');
        } else {
            return;
        }
    }

    def jumpToInstructions() {
        String id = request.getRemoteAddr();
        int age = Integer.valueOf(params.age);
        String gender = params.gender;
        grailsApplication.mainContext.getBean("sessionScopedService").id = id;
        grailsApplication.mainContext.getBean("sessionScopedService").age = age;
        grailsApplication.mainContext.getBean("sessionScopedService").gender = gender;
        redirect(controller: 'instructions', action: 'index');
    }
}