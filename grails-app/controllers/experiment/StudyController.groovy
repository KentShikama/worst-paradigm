package experiment

class StudyController {

    def personService;
    def grailsApplication;

    def lineDrawings() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService")
        if (sessionScopedService.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            return [items: personService.createItems()];
        }
    }

    def photographs() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService")
        if (sessionScopedService.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            return [items: personService.createItems()];
        }
    }
}
