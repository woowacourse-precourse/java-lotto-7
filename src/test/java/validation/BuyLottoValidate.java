package validation;

import static lotto.validation.BuyLottoValidate.amountValidation;
import static lotto.validation.BuyLottoValidate.checkNegativeNumber;
import static lotto.validation.BuyLottoValidate.thousandMultiple;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BuyLottoValidate {

    @Test
    void 유효하지_않은_보너스_입력은_예외가_발생한다() {
        assertThatThrownBy(() -> amountValidation("가나다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_가격으로_음수가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> checkNegativeNumber(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_가격으로_천의_배수가_입력되지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> thousandMultiple(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_가격으로_천의_배수가_입력되면_나눠서_로또_갯수로_반환한다() {
        int lottoAmount = 10000;
        int expectedOutput = 10;
        int lottoCount = thousandMultiple(lottoAmount);
        assertEquals(lottoCount, expectedOutput);
    }
}
