package lotto.view;

public class ConsoleOutput implements Output {

    private static final String ERROR_PREFIX = "[ERROR]";

    @Override
    public void outputError(Exception exception) {
        System.out.printf("%s %s", ERROR_PREFIX, exception.getMessage());
        System.out.println();
        System.out.println();
    }

}
