package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void 빈_값이_입력되었다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new PurchaseAmount(input);
                }).withMessageContaining("빈 값은 입력하실 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"^&", "1j"})
    void 숫자로_변환되지_않는다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new PurchaseAmount(input);
                }).withMessageContaining("숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-1000"})
    void 양수가_아니라면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new PurchaseAmount(input);
                }).withMessageContaining("양수를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "1", "2001"})
    void 천으로_나눠질_수_없다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new PurchaseAmount(input);
                }).withMessageContaining("1,000원으로 나눠질 수 있는 금액을 입력하셔야 합니다.");
    }

    @Test
    void 수익률을_계산한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
        int totalAmount = 5000;

        double rateOfReturn = purchaseAmount.findRateOfReturn(totalAmount);

        assertEquals(62.5, rateOfReturn);
    }
}