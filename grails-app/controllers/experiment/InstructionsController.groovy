package experiment

class InstructionsController {

    def grailsApplication;

    def index() {
        if (grailsApplication.mainContext.getBean("sessionScopedService").finished) {
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
        if (Math.random() < 0.5) {
            grailsApplication.mainContext.getBean("sessionScopedService").studyType = 'lineDrawings';
            redirect(controller: 'study', action: 'lineDrawings');
        } else {
            grailsApplication.mainContext.getBean("sessionScopedService").studyType = 'photographs';
            redirect(controller: 'study', action: 'photographs');
        }
    }
}
