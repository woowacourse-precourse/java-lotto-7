package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.model.dto.LottoStatisticsResponse;
import lotto.model.dto.LottosResponse;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private static final String VALID_PAYMENT = "8000";
    private static final String VALID_WINNING_NUMBERS = "1,2,3,4,5,6";
    private static final String VALID_BONUS_NUMBER = "7";

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

    @Test
    void 당첨번호_저장_성공_테스트() {
        // given

        // when
        String result = lottoService.saveWinningLottos(VALID_WINNING_NUMBERS);

        // then
        assertThat(result).isEqualTo("success");
    }

    @Test
    void 보너스번호_저장_성공_테스트() {
        // given

        // when
        String result = lottoService.saveBonusNumber(VALID_BONUS_NUMBER);

        // then
        assertThat(result).isEqualTo("success");
    }

    @Test
    void 당첨통계_수익률_반환_성공_테스트() {
        // given
        Integer customerId = lottoService.savePayment(VALID_PAYMENT);
        lottoService.issueLottos(customerId);
        lottoService.saveWinningLottos(VALID_WINNING_NUMBERS);

        // when
        LottoStatisticsResponse statisticsResponse = lottoService.statisticsWinningOfCustomerLottos(customerId);

        // then
        assertThat(statisticsResponse).isNotNull();
        assertThat(statisticsResponse.statistics()).containsKeys("3", "4", "5", "5B", "6");
        assertThat(statisticsResponse.rateOfRevenue()).isInstanceOf(BigDecimal.class);
    }
}
