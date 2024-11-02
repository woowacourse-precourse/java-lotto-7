package lotto.model;

public class LottoBonusNumber {
    int START_LOTTO_NUMBER = 1;
    int FINISH_LOTTO_NUMBER = 45;
    private final int bonusNumber;

    public LottoBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (START_LOTTO_NUMBER <= bonusNumber && bonusNumber <= FINISH_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.", START_LOTTO_NUMBER, FINISH_LOTTO_NUMBER));
        }
    }


}
