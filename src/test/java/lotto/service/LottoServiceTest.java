package lotto.service;

import lotto.constants.ErrorMessageConstants;
import lotto.validation.InputValidator;
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
}
