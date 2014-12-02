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

    Set<String> recalledWords;
    boolean didRecallCriticalLureInFreeRecall;

    List<String> recognitionWordList;
    boolean didRecallCriticalLureInRecognition;
}
