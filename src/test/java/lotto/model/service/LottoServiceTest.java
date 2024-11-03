package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.dto.LottosResponse;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private static final String VALID_PAYMENT = "8000";

    private final LottoService lottoService = new LottoService();

    @Test
    void 지불금액_저장_성공_테스트() {
        // given

        // when
        Integer customerId = lottoService.savePayment(VALID_PAYMENT);

        // then
        assertThat(customerId).isNotNull();
    }

    @Test
    void 로또_발행_성공_테스트() {
        // given
        Integer customerId = lottoService.savePayment(VALID_PAYMENT);

        // when
        LottosResponse generatedLottos = lottoService.issueLottos(customerId);

        // then
        assertThat(generatedLottos).isNotNull();
        assertThat(generatedLottos.lottos()).hasSize(8);
    }
}
