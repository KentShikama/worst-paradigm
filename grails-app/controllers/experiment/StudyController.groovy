package experiment

class StudyController {

    def itemService;

    def lineDrawings() {
        return [items: itemService.createItems()];
    }

    def photographs() {
        return [items: itemService.createItems()];
    }
}
