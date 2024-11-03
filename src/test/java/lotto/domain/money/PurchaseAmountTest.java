package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoApplicationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class PurchaseAmountTest {

    @CsvSource(textBlock = """
            -1,'[ERROR] 구입 금액은 1,000원 이상, 100,000원 이하여야 합니다.'
            999,'[ERROR] 구입 금액은 1,000원 이상, 100,000원 이하여야 합니다.'
            100001,'[ERROR] 구입 금액은 1,000원 이상, 100,000원 이하여야 합니다.'
            1500,'[ERROR] 구입 금액은 1,000원 단위여야 합니다.'
            """)
    @ParameterizedTest
    void 유효한_구입_금액이_아니면_예외가_발생한다(int amount, String message) {
        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessage(message);
    }

}
