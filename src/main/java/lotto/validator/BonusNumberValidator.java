package lotto.validator;

public class BonusNumberValidator implements Validator<Integer> {

    @Override
    public void validate(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
