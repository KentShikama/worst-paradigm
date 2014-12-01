package experiment

class StudyController {

    def personService;

    def lineDrawings() {
        return [items: personService.createItems()];
    }

    def photographs() {
        return [items: personService.createItems()];
    }
}
