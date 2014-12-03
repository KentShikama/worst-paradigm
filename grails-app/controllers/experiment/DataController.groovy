package experiment

class DataController {
    def index() {
        return [people: Person.list()];
    }
}
