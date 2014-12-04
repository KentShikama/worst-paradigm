package experiment;

class StartController {

    def grailsApplication;

    def index() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService")
        if (sessionScopedService.finished) {
            redirect(controller: 'debriefing', action: 'index');
        } else {
            return;
        }
    }

    def jumpToInstructions() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService")
        String address = request.getRemoteAddr();
        int age = Integer.valueOf(params.age);
        String gender = params.gender;
        sessionScopedService.address = address;
        sessionScopedService.age = age;
        sessionScopedService.gender = gender;
        redirect(controller: 'instructions', action: 'index');
    }
}