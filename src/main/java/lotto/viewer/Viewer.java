package lotto.viewer;

public interface Viewer {

    String ERROR_SIGN = "[ERROR] ";

    String getInput();

    void printError(Exception e);

    void printMessage(String message);
}
