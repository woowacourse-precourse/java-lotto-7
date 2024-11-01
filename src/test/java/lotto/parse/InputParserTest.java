package lotto.parse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void init() {
        this.inputParser = new InputParser();
    }

    @Test
    void parsePurchaseAmount_입력으로_들어온_구매금액을_성공적으로_Long으로_파싱한다() {
        // given
        String purchaseAmount = "12341234";

        // when
        Long result = inputParser.parsePurchaseAmount(purchaseAmount);

        // then
        assertThat(String.valueOf(result)).isEqualTo(purchaseAmount);
    }

    @Test
    void parsePurchaseAmount_구매금액에_문자가_있으면_실패한다() {
        // given
        String purchaseAmount = "문자123";

        // when

        // then
        assertThatThrownBy(() -> inputParser.parsePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_MUST_LONG);
    }

    @Test
    void parsePurchaseAmount_구매금액이_Long타입의_범위를_벗어나면_실패한다() {
        // given
        String purchaseAmount = "122312123131211213121321231231321231231231231321231";

        // when

        // then
        assertThatThrownBy(() -> inputParser.parsePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_MUST_LONG);
    }
}