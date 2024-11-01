package lotto.model;

import org.junit.jupiter.api.Test;

import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_MINUS;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_ZERO_VALUE;
import static lotto.constants.ErrorMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseAmountTest {
    @Test
    void 구입_금액을_천원_단위로_나누어_로또_구매_개수를_구할_수_있다() {
        // given
        String rawPurchaseAmount = "2000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(rawPurchaseAmount);

        // when
        int real = purchaseAmount.calculateLottoCount();

        // then
        int expected = Integer.parseInt(rawPurchaseAmount) / 1000;
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 문장_맨_앞에_공백이_오는_경우_예외가_발생한다() {
        // given
        String rawPurchaseAmount = " 2000";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .withMessage(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    @Test
    void 문장_맨_뒤에_공백이_오는_경우_예외가_발생한다() {
        // given
        String rawPurchaseAmount = "2000 ";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .withMessage(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    @Test
    void 문장_맨_앞_맨_뒤에_공백이_오는_경우_예외가_발생한다() {
        // given
        String rawPurchaseAmount = " 2000 ";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .withMessage(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    @Test
    void 정수가_입력_되지_않는_경우_예외가_발생한다() {
        // given
        String rawPurchaseAmount = "string";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .withMessage(INPUT_VALUE_MUST_BE_NUMERIC);
    }

    @Test
    void 입력된_값이_0인_경우_예외가_발생한다() {
        // given
        String rawPurchaseAmount = "0";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .withMessage(NOT_ALLOWED_ZERO_VALUE);
    }

    @Test
    void 입력된_값이_음수인_경우_예외가_발생한다() {
        // given
        String rawPurchaseAmount = "-1";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .withMessage(NOT_ALLOWED_MINUS);
    }

    @Test
    void 입력된_값이_1000_단위가_아닌_경우_예외가_발생한다() {
        // given
        String rawPurchaseAmount = "2001";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(rawPurchaseAmount))
                .withMessage(PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000);
    }
}
