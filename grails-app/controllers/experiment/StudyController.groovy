package experiment

class StudyController {

    def personService;
    def sessionScopedServiceProxy;

    def lineDrawings() {
        if (sessionScopedServiceProxy.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            return [items: personService.createItems()];
        }
    }

    def photographs() {
        if (sessionScopedServiceProxy.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            return [items: personService.createItems()];
        }
    }
}
