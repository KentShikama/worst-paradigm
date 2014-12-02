package experiment

class SessionScopedService {
    static scope = 'session';
    static proxy = true;

    boolean finished = false;

    String id;
    int age;
    String gender;

    String studyType;

    int distractionCount = 0;

    ArrayList<String> recalledWords;
    boolean didRecallCriticalLureInFreeRecall;

    ArrayList<String> recognitionWordList;
    boolean didRecallCriticalLureInRecognition;
}
