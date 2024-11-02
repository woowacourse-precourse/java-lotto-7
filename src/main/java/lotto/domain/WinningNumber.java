package lotto.domain;

public class WinningNumber {

    private Lotto winningNumber;
    private int bonusNumber;

    public WinningNumber(Lotto winningNumber, int bonusNumber) {
        validate();

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public void validate() {

    }
}
