package lotto.viewer;

public interface Viewer {

    String getInput();

    void printError(Exception e);

    void printMessage(String message);
}
