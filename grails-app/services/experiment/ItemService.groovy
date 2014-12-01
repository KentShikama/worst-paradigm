package experiment

class ItemService {
    List<Item> createItems() {
        List<String> wordList = ["shoe","hand","toe","kick","sandals","soccer","yard","walk","ankle","arm","boot","inch","sock","smell","mouth"].toList();
        List<Item> itemList = new ArrayList<>();
        for (String word: wordList) {
            Item item = new Item(word: word, lineDrawingURL: word + "-linedrawing.png", photographURL: word + "-photograph.png");
            itemList.add(item);
        }
        return itemList;
    }
}
