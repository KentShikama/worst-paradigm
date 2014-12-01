package experiment

class DistractionController {

    int firstNumber;
    int secondNumber;

    int count = 0;

    def index() {
        if (count == 0) {
            return showFirstQuestionAndIncrementCount();
        } else {
            return checkAnswerAndContinue();
        }
    }

    private LinkedHashMap<String, Integer> showFirstQuestionAndIncrementCount() {
        count++;
        return showNewQuestion();
    }

    private LinkedHashMap<String, Serializable> checkAnswerAndContinue() {
        int enteredAnswer = Integer.valueOf(params.answer);
        int trueAnswer = firstNumber + secondNumber;
        if (enteredAnswer == trueAnswer) {
            count++;
            return showNextQuestionOrRedirect(count)
        } else {
            return showSameQuestion(enteredAnswer);
        }
    }

    private Object showNextQuestionOrRedirect(int count) {
        if (hasAnsweredEnoughQuestions(count)) {
            redirect(controller: 'recall', action: 'index');
        } else {
            return showNewQuestion();
        }
    }
    private boolean hasAnsweredEnoughQuestions(int count) {
        count > 1
    }

    private LinkedHashMap<String, Integer> showNewQuestion() {
        firstNumber = (int) (Math.random() * 100);
        secondNumber = (int) (Math.random() * 100);
        return [firstNumber: firstNumber, secondNumber: secondNumber];
    }

    private LinkedHashMap<String, Serializable> showSameQuestion(int enteredAnswer) {
        String errorMessage = "Answer is not " + enteredAnswer + ". Try again.";
        return [firstNumber: firstNumber, secondNumber: secondNumber, errorMessage: errorMessage];
    }
}
