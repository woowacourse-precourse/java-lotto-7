package lotto.model;

import java.util.List;

import static lotto.message.ErrorMessage.*;
public class LottoGame {
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public LottoGame(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateLottoGame();
    }

    private void validateLottoGame(){
        if (isWinningNumbersContainBonusNumber()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER.getMessage());
        }
    }

    private boolean isWinningNumbersContainBonusNumber(){
        return getWinningNumbers().contains(getBonusNumber());
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers.getWinningNumbers();
    }

    public int getBonusNumber(){
        return bonusNumber.getBonusNumber();
    }

}
