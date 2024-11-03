package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PurchaseAmountTest {

    @NullAndEmptySource
    @CsvSource({"1000.1", "test"})
    @ParameterizedTest
    void 구입_금액이_정수가_아니면_예외가_발생한다(String amount) {
        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 정수여야 합니다.");
    }

    @CsvSource(textBlock = """
            -1,[ERROR] 구입 금액은 0보다 작을 수 없습니다.
            900,'[ERROR] 구입 금액은 1,000원 단위여야 합니다.'
            """)
    @ParameterizedTest
    void 유효한_구입_금액이_아니면_예외가_발생한다(String amount, String message) {
        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

}
