package experiment

class RecognitionController {

    private static final int SHORTENED_LIST_LENGTH = 10;

    def index() {
        Set recalledWordList = params.recalledWords;
        return [wordList: createRecognitionWordList(recalledWordList)];
    }

    List<String> createRecognitionWordList(Set<String> recalledWordList) {
        List<String> relatedWrongWordList = ["finger", "nail", "nose", "mile", "elbow", "leg", "knee", "calf", "flip flops", "cleats", "lips", "laces", "tights", "football", "rugby", "heel", "sole", "sweaty", "velcro", "throw", "catch"].toList();
        List<String> correctWordList = ["shoe", "hand", "toe", "kick", "sandals", "soccer", "yard", "walk", "ankle", "arm", "boot", "inch", "sock", "smell", "mouth"].toList();
        List<String> wordsNotRecalledList = buildWordsNotRecalledList(correctWordList, recalledWordList.toList());
        List<String> combinedFullLengthList = new ArrayList<>();
        combinedFullLengthList.addAll(relatedWrongWordList);
        combinedFullLengthList.addAll(wordsNotRecalledList);
        Collections.shuffle(combinedFullLengthList);
        List<String> combinedShortenedLengthList = combinedFullLengthList.subList(0, SHORTENED_LIST_LENGTH-1);
        combinedShortenedLengthList.add((int)(Math.random() * (SHORTENED_LIST_LENGTH)), "foot");
        return combinedShortenedLengthList;
    }

    private List<String> buildWordsNotRecalledList(List<String> correctWordList, List<String> recalledWordList) {
        List<String> wordsNotRecalledList = new ArrayList<String>();
        for (String word : correctWordList) {
            boolean didRecallWord = false;
            for (String recalledWord : recalledWordList) {
                if (recalledWord.equals(word)) {
                    didRecallWord = true;
                }
            }
            if (!didRecallWord) {
                wordsNotRecalledList.add(word);
            }
        }
        return wordsNotRecalledList;
    }
}
