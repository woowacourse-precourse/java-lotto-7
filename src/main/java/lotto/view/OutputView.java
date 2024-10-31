package lotto.view;

public class OutputView {
    private final static String EXAMPLE = "This is the exam";
    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printExam(){
        printMessage(EXAMPLE);
    }
}
