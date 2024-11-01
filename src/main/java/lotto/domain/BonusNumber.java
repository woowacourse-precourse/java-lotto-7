package lotto.domain;

import lotto.error.enums.LottoErrorMessage;

public class BonusNumber {

    private final Integer bonusNumber;

    public BonusNumber(String input, WinningNumbers winningNumbers) {
        validate(input, winningNumbers);
        this.bonusNumber = Integer.parseInt(input);
    }

    private void validate(String input, WinningNumbers winningNumbers) {

        int n = 0;
        try{
            n = Integer.parseInt(input);
            if(n < 1 || n > 45)
                throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_RANGE_EXCEPTION.getMsg());
        }

        if(winningNumbers.getNumbers().contains(n))
            throw new IllegalArgumentException(LottoErrorMessage.BONUS_WINNING_CONFLICT_EXCEPTION.getMsg());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
