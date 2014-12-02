package experiment

class RecallController {

    private static final String CRITICAL_LURE = "foot";
    Set<String> recalledWords = new TreeSet<String>();

    def sessionScopedServiceProxy;

    def index() {
        if (sessionScopedServiceProxy.finished) {
            redirect(controller: 'debriefing', action: 'index');
            return;
        } else {
            return [recalledWords: recalledWords];
        }
    }

    def addWord() {
        String recalledWord = params.word;
        recalledWords.add(recalledWord);
        redirect(action: 'index');
    }

    def deleteWord() {
        String wordToDelete = params.word;
        Set<String> newRecalledWords = new TreeSet<String>();
        for (String word : recalledWords) {
            if (!wordToDelete.equals(word)) {
                newRecalledWords.add(word);
            }
        }
        recalledWords = newRecalledWords;
        redirect(action: 'index');
    }

    def submit() {
        for (String word : recalledWords) {
            if (word.equals(CRITICAL_LURE)) {
                sessionScopedServiceProxy.recalledWords = recalledWords;
                sessionScopedServiceProxy.didRecallCriticalLureInFreeRecall = true;
                redirect(controller: 'debriefing', action: 'index');
                return;
            }
        }
        sessionScopedServiceProxy.didRecallCriticalLureInFreeRecall = false;
        redirect(controller: 'recognition', action: 'index');
    }
}
