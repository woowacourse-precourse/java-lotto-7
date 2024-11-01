package lotto;

public class WinningNumbersWithBonusNumber {

    public static final String DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호는 당첨 번호와 겹칠 수 없습니다.";

    private final WinningLottoNumbers numbers;
    private final LottoNumber bonusNumber;

    public WinningNumbersWithBonusNumber(WinningLottoNumbers numbers, LottoNumber bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(WinningLottoNumbers numbers, LottoNumber bonusNumber) {
        if (numbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
