package experiment

class InstructionsController {

    def sessionScopedServiceProxy;

    def index() {
        if (sessionScopedServiceProxy.finished) {
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
            sessionScopedServiceProxy.studyType = 'lineDrawings';
            redirect(controller: 'study', action: 'lineDrawings');
        } else {
            sessionScopedServiceProxy.studyType = 'photographs';
            redirect(controller: 'study', action: 'photographs');
        }
    }
}
