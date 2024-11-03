package lotto;

public class MainProgram {
    private final UserInputService inputHandler = new UserInputService();
    public void run() {
        int amount = inputHandler.getPurchaseAmount();
    }
}
