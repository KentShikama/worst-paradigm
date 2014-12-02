package experiment;

class StartController {

    def sessionScopedServiceProxy;

    def index() {
        if (sessionScopedServiceProxy.finished) {
            redirect(controller: 'debriefing', action: 'index');
        } else {
            return;
        }
    }

    def jumpToInstructions() {
        String id = request.getRemoteAddr();
        int age = Integer.valueOf(params.age);
        String gender = params.gender;
        sessionScopedServiceProxy.id = id;
        sessionScopedServiceProxy.age = age;
        sessionScopedServiceProxy.gender = gender;
        redirect(controller: 'instructions', action: 'index');
    }
}