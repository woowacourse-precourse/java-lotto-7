package lotto;

public class WinningNumberInputHandler extends InputHandler{
    private String winningNumber;

    @Override
    public void validateInput() {

    }

    private String[] splitNumbers() {
        return winningNumber.split(",");
    }
}
