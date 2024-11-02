package lotto.model;

import java.util.List;

import static lotto.message.ErrorMessage.*;
public class LottoGame {
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public LottoGame(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateLottoGame(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateLottoGame(WinningNumbers winningNumbers, BonusNumber bonusNumber){
        if (isWinningNumbersContainBonusNumber(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER.getMessage());
        }
    }

    private boolean isWinningNumbersContainBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber){
        return winningNumbers.getWinningNumbers().contains(bonusNumber.getBonusNumber());
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers.getWinningNumbers();
    }

    public int getBonusNumber(){
        return bonusNumber.getBonusNumber();
    }

}
