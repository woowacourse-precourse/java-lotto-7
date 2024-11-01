package lotto.domain;

import lotto.error.LottoErrorMessage;

public class BonusNumber {

    private final Integer bonusNumber;

    public BonusNumber(String input) {
        validate(input);
        this.bonusNumber = Integer.parseInt(input);
    }

    private void validate(String input) {
        try{
            int n = Integer.parseInt(input);
            if(n < 1 || n > 45)
                throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_RANGE_EXCEPTION.getMsg());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
