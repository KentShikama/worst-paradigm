package experiment

class InstructionsController {

    def grailsApplication;

    def index() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService")
        if (sessionScopedService.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            return;
        }
    }

    def jumpToStudy() {
        redirectToEitherStudy();
    }

    private void redirectToEitherStudy() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService")
        if (Math.random() < 0.5) {
            sessionScopedService.studyType = 'lineDrawings';
            redirect(controller: 'study', action: 'lineDrawings');
        } else {
            sessionScopedService.studyType = 'photographs';
            redirect(controller: 'study', action: 'photographs');
        }
    }
}
