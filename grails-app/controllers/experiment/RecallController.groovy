package experiment

class RecallController {

    private static final String CRITICAL_LURE = "foot";
    def grailsApplication;

    def index() {
        if (grailsApplication.mainContext.getBean("sessionScopedService").finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            if (grailsApplication.mainContext.getBean("sessionScopedService").recalledWords == null || grailsApplication.mainContext.getBean("sessionScopedService").recalledWords.isEmpty()) {
                grailsApplication.mainContext.getBean("sessionScopedService").recalledWords = new ArrayList<String>();
            }
            return [recalledWords: grailsApplication.mainContext.getBean("sessionScopedService").recalledWords];
        }
    }

    def addWord() {
        String recalledWord = params.word;
        grailsApplication.mainContext.getBean("sessionScopedService").recalledWords.add(recalledWord);
        redirect(action: 'index');
    }

    def deleteWord() {
        String wordToDelete = params.word;
        Set<String> newRecalledWords = new TreeSet<String>();
        for (String word : grailsApplication.mainContext.getBean("sessionScopedService").recalledWords) {
            if (!wordToDelete.equals(word)) {
                newRecalledWords.add(word);
            }
        }
        grailsApplication.mainContext.getBean("sessionScopedService").recalledWords = newRecalledWords;
        redirect(action: 'index');
    }

    def submit() {
        for (String word : grailsApplication.mainContext.getBean("sessionScopedService").recalledWords) {
            if (word.equals(CRITICAL_LURE)) {
                grailsApplication.mainContext.getBean("sessionScopedService").didRecallCriticalLureInFreeRecall = true;
                redirect(controller: 'debriefing', action: 'index');
                return;
            }
        }
        grailsApplication.mainContext.getBean("sessionScopedService").didRecallCriticalLureInFreeRecall = false;
        redirect(controller: 'recognition', action: 'index');
    }
}
