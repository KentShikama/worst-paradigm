package experiment

class StudyController {

    def personService;
    def grailsApplication;

    def lineDrawings() {
        if (grailsApplication.mainContext.getBean("sessionScopedService").finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            return [items: personService.createItems()];
        }
    }

    def photographs() {
        if (grailsApplication.mainContext.getBean("sessionScopedService").finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            return [items: personService.createItems()];
        }
    }
}
