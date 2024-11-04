package lotto;

public class OutputView {

    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    public void printException(String detailedMessage) {
        System.out.println(EXCEPTION_PREFIX + detailedMessage);
    }
}
