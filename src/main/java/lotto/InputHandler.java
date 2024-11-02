package lotto;

public abstract class InputHandler {
    public abstract void validateInput();

    public void throwIllegalArgumentException(String message) {
        try{
            throw new IllegalArgumentException(message);
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
}
