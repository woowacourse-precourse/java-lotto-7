package lotto.viewHandler.validator;

import lotto.viewHandler.exception.NotUnitPurchaseMoney;
import lotto.viewHandler.validator.validatorImpl.LottoPurchaseUnitValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseUnitValidatorTest {
    private final LottoPurchaseUnitValidator validator;

    public LottoPurchaseUnitValidatorTest(){
        this.validator = new LottoPurchaseUnitValidator();
    }

    @Test
    void 정상_작동_확인() {
        Integer input = 10_000;
        validator.validate(input);
    }

    @Test
    void 검증_확인() {
        Integer input = 10_100;
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(NotUnitPurchaseMoney.class);
    }
}