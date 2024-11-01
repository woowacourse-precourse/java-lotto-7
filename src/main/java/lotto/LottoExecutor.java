package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.BonusNumber;
import lotto.input.Cost;
import lotto.input.Input;
import lotto.input.WinningNumber;

public class LottoExecutor {

    private Cost cost;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public LottoExecutor() {
        this.cost = new Cost();
        this.winningNumber = new WinningNumber();
    }

    public void run() {
        validateInput(cost);
        validateInput(winningNumber);
        bonusNumber = new BonusNumber(winningNumber.getLotto().getNumbers());
        validateInput(bonusNumber);
    }

    private void validateInput(Input input) {

        boolean success = false;

        while (!success) {
            try {
                input.validate(Console.readLine());
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
