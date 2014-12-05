package experiment

class RecallController {

    private static final String CRITICAL_LURE = "foot";
    def grailsApplication;

    def index() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService");
        if (sessionScopedService.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            if (sessionScopedService.recalledWords == null || sessionScopedService.recalledWords.isEmpty()) {
                sessionScopedService.recalledWords = new ArrayList<String>();
            }
            return [recalledWords: sessionScopedService.recalledWords];
        }
    }

    def addWord() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService");
        String recalledWord = params.word;
        String recalledWordFormatted = recalledWord.toLowerCase().trim();
        if (!recalledWordFormatted.isEmpty()) {
            boolean isNewWord = true;
            for (String wordsRecalledSoFar : sessionScopedService.recalledWords) {
                if (recalledWord.equals(wordsRecalledSoFar)) {
                    isNewWord = false;
                }
            }
            if (isNewWord) {
                sessionScopedService.recalledWords.add(recalledWordFormatted);
            }
        }
        redirect(action: 'index');
    }

    def deleteWord() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService");
        String wordToDelete = params.word;
        Set<String> newRecalledWords = new TreeSet<String>();
        for (String word : sessionScopedService.recalledWords) {
            if (!wordToDelete.equals(word)) {
                newRecalledWords.add(word);
            }
        }
        sessionScopedService.recalledWords = newRecalledWords;
        redirect(action: 'index');
    }

    def submit() {
        def sessionScopedService = grailsApplication.mainContext.getBean("sessionScopedService");
        for (String word : sessionScopedService.recalledWords) {
            if (word.equals(CRITICAL_LURE)) {
                sessionScopedService.didRecallCriticalLureInFreeRecall = true;
                redirect(controller: 'debriefing', action: 'index');
                return;
            }
        }
        sessionScopedService.didRecallCriticalLureInFreeRecall = false;
        redirect(controller: 'recognition', action: 'index');
    }
}
