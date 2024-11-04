package lotto.validate;

public class BuyLottoAmountValidate implements LottoValidate {
    @Override
    public void validate(int value) {
        if(value <= 0 || value % 1000 != 0) {
            throw new IllegalArgumentException("\n로또 금액과 맞지 않습니다.\n");
        }
    }
}
