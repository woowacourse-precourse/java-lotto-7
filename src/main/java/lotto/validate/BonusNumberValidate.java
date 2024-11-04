package lotto.validate;

public class BonusNumberValidate implements LottoValidate {
    @Override
    public void validate(int value) {
        if(value < 1 || value > 45) {
            throw new IllegalArgumentException("\n올바르지 않은 로또 번호입니다.\n");
        }
    }
}
