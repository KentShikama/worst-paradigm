package experiment

class InstructionsController {

    def cookieService;

    def index() {}

    def jumpToStudy() {
        redirectToEitherStudy();
    }

    private void redirectToEitherStudy() {
        if (Math.random() < 0.5) {
            cookieService.setCookie("studyType","lineDrawings");
            redirect(controller: 'study', action: 'lineDrawings');
        } else {
            cookieService.setCookie("studyType","photographs");
            redirect(controller: 'study', action: 'photographs');
        }
    }
}
