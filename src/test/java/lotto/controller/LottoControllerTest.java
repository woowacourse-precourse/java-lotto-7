package lotto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.validator.PurchaseValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private LottoController lottoController;
    private LottoService lottoService;
    private StatisticsService statisticsService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        statisticsService = new StatisticsService();
        lottoController = new LottoController(lottoService, statisticsService);
    }

    @Test
    @DisplayName("구입 금액에 따라 올바른 수량의 로또가 생성되는지 테스트")
    void testGenerateLottosWithPurchaseAmount() {
        int purchaseAmount = 5000;
        int expectedLottoCount = purchaseAmount / 1000;

        LottoTicket lottoTicket = lottoService.generateLottos(purchaseAmount);

        assertEquals(expectedLottoCount, lottoTicket.getLottos().size(),
                "로또 생성 수가 예상과 일치하지 않습니다.");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호를 사용해 올바른 통계와 수익률을 계산하는지 테스트")
    void testCalculateStatisticsAndRateEarning() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoTicket lottoTicket = lottoService.generateLottos(5000);
        Map<LottoResult, Integer> result = lottoService.calculateStatisticsLottoResult(lottoTicket, winningNumbers,
                bonusNumber);

        double rateEarning = statisticsService.calculateRateEarning(result, 5000);

        System.out.printf("당첨 통계: %s%n", result);
        System.out.printf("총 수익률: %.1f%%%n", rateEarning);
    }

    @Test
    @DisplayName("잘못된 입력에 대한 예외 처리가 적절히 수행되는지 테스트")
    void testInvalidPurchaseAmount() {
        String invalidPurchaseAmount = "invalid_input";

        assertThrows(IllegalArgumentException.class, () -> {
            PurchaseValidator.validatePurchaseAmount(invalidPurchaseAmount);
        });
    }
}
