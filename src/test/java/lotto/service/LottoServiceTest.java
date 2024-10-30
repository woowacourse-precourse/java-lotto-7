package lotto.service;

import lotto.constants.ErrorMessageConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {
    private final LottoService lottoService = new LottoServiceImpl();

    @Test
    void 로또_구입_정상_금액_입력_시_로또_장수_반환_테스트() {
        int purchaseAmount = 5000;
        int expectedLottoCount = 5;

        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }

    @Test
    void 로또_구입_금액_단위_예외_테스트() {
        int invalidPurchaseAmount = 5500;

        assertThatThrownBy(() -> lottoService.calculateLottoCount(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @Test
    void 로또_구입_금액_양의_정수_예외_테스트() {
        int invalidPurchaseAmount = -1000;

        assertThatThrownBy(() -> lottoService.calculateLottoCount(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 양의 정수로 입력해야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "    "})
    void 로또_구입_금액_입력값_null_또는_공백_예외_테스트(String invalidInput) {
        assertThatThrownBy(() -> lottoService.calculateLottoCount(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.EMPTY_PURCHASE_AMOUNT);
    }
}
