package experiment;

class StartController {

    def cookieService;

    def index() {}

    def jumpToInstructions() {
        String id = request.getRemoteAddr() + Calendar.getInstance().time.getDateTimeString();
        String age = params.age;
        String gender = params.gender;
        cookieService.setCookie("sessionID",id);
        cookieService.setCookie("age", age);
        cookieService.setCookie("gender", gender);
        redirect(controller: 'instructions', action: 'index');
    }
}