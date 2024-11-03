package lotto;

public abstract class InputHandler {
    public abstract void validateInput();

    public void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
}
