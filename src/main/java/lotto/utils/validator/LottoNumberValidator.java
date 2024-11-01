package lotto.utils.validator;

public class LottoNumberValidator implements Validator<Integer>{
    private final int LOWER_BOUND = 1;
    private final int UPPER_BOUND = 45;

    @Override
    public void validate(Integer value) {
        if (value < LOWER_BOUND || value > UPPER_BOUND) {
            throw new IllegalArgumentException("숫자가 로또 번호 범위인 1이상 45이하에 존재하지 않습니다.");
        }
    }



}
