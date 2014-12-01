package experiment

class RecallController {

    private static final String CRITICAL_LURE = "foot";
    Set<String> recalledWords = new TreeSet<String>();

    def index() {
        [recalledWords: recalledWords];
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
                redirect(controller: 'debriefing', action: 'fromRecall', params: [recalledWords: recalledWords]);
                return;
            }
        }
        redirect(controller: 'recognition', action: 'index', params: [recalledWords: recalledWords]);
    }
}
