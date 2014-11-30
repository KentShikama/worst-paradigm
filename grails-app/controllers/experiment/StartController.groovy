package experiment;

class StartController {
    def index() {}

    def start() {
        String age = params.age;
        String gender = params.gender;
        boolean terms = params.terms;
        System.out.println("Age: " + age + ", Gender: " + gender + ", Terms: " + terms);
        render("Success!");
    }
}