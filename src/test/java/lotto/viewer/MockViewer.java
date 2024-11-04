package lotto.viewer;

public class MockViewer implements Viewer {
    @Override
    public String getInput() {
        return "";
    }

    @Override
    public void printError(Exception e) {
    }

    @Override
    public void printMessage(String message) {
    }
}
