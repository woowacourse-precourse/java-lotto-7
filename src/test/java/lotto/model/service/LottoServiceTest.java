package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void 지불금액_저장_성공_테스트() {
        // given
        String validPayment = "8000";

        // when
        Integer customerId = lottoService.savePayment(validPayment);

        // then
        assertThat(customerId).isNotNull();
    }
}
