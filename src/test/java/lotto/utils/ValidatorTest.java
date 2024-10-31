package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @DisplayName("priceValidator 메서드 테스트_01")
    @Test
    void 천원_단위_입력이_아니면_예외가_발생한다() {
        String inputPrice = "11100";

        Assertions.assertThatThrownBy(()->Validator.priceValidator(inputPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("priceValidator 메서드 테스트_02")
    @Test
    void 가격_입력이_정수가_아니면_예외가_발생한다() {
        String inputPrice = "1000won";

        Assertions.assertThatThrownBy(()->Validator.priceValidator(inputPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
