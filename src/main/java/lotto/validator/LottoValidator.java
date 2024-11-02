package lotto.validator;

import java.util.List;

public class LottoValidator extends Validator {
    private final String lotto;

    public LottoValidator(String lotto) {
        this.lotto = lotto;
    }

    public void validate() {

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    protected void validateee() {

    }
}
