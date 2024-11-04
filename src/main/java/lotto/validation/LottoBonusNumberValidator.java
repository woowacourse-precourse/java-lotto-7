package lotto.validation;

public class LottoBonusNumberValidator implements Validator<Integer>{
    static int START_LOTTO_NUMBER = 1;
    static int FINISH_LOTTO_NUMBER = 45;

    @Override
    public void validate(Integer bonusNumber) {
        if (bonusNumber < START_LOTTO_NUMBER || FINISH_LOTTO_NUMBER < bonusNumber) {
            throw new IllegalArgumentException(String.format("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.", START_LOTTO_NUMBER, FINISH_LOTTO_NUMBER));
        }
    }

}
