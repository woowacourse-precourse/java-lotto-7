package lotto;

public record LottoWinNumbers(Lotto lotto, int bonusNumber) {
    public LottoWinNumbers {
        validate(lotto, bonusNumber);
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (lotto.numbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.format());
        }
    }
}
