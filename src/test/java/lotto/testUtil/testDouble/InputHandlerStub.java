package lotto.testUtil.testDouble;

import java.util.List;
import lotto.io.inputHandler.InputHandler;

public class InputHandlerStub implements InputHandler {

    private Integer purchaseCost;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public void stubPurchaseCost(int purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public void stubWinningNumbers(Integer... winningNumbers) {
        this.winningNumbers = List.of(winningNumbers);
    }

    public void stubBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public int handlePurchaseCost() {
        if (purchaseCost == null) {
            throw new RuntimeException("purchaseCost를 스텁해주세요.");
        }
        return purchaseCost;
    }

    @Override
    public List<Integer> handleWinningNumbers() {
        if (winningNumbers == null) {
            throw new RuntimeException("winningNumbers를 스텁해주세요.");
        }
        return winningNumbers;
    }

    @Override
    public int handleBonusNumber() {
        if (bonusNumber == null) {
            throw new RuntimeException("bonusNumber를 스텁해주세요.");
        }
        return bonusNumber;
    }
}
