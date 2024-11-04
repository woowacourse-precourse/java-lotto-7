package lotto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoService;
import lotto.service.StatisticsService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private LottoController lottoController;
    private LottoService lottoService;
    private StatisticsService statisticsService;

    @BeforeEach
    void setUp() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        lottoService = new LottoService(generator);
        statisticsService = new StatisticsService();
        lottoController = new LottoController(lottoService, statisticsService);
    }

    @Test
    @DisplayName("LottoController의 주요 흐름 통합 테스트")
    void testRunMethodIntegration() {
        // Step 1: 구입 금액을 설정하고 로또 티켓 발행 테스트
        int purchaseAmount = 5000;
        LottoTicket lottoTicket = lottoService.generateLottos(purchaseAmount);
        int expectedLottoCount = purchaseAmount / 1000;

        // 로또 티켓의 개수가 예상과 일치하는지 확인
        assertEquals(expectedLottoCount, lottoTicket.getLottos().size(), "로또 개수가 예상과 다릅니다.");

        // Step 2: 당첨 번호 입력 및 검증
        List<String> winningNumbersInput = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<Integer> winningNumbers = WinningNumberValidator.validateWinningNumbers(winningNumbersInput);
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers, "당첨 번호가 예상과 다릅니다.");

        // Step 3: 보너스 번호 입력 및 검증
        String bonusNumberInput = "7";
        int bonusNumber = BonusNumberValidator.validateBonusNumber(bonusNumberInput, winningNumbers);
        assertEquals(7, bonusNumber, "보너스 번호가 예상과 다릅니다.");

        // Step 4: 통계 계산 확인
        Map<LottoResult, Integer> statistics = lottoService.calculateStatisticsLottoResult(lottoTicket, winningNumbers,
                bonusNumber);

        // 특정 당첨 결과와 보너스 매칭 결과에 대한 확인
        assertEquals(0, statistics.getOrDefault(LottoResult.SIX, 0), "6개 일치 통계가 예상과 다릅니다.");
        assertEquals(0, statistics.getOrDefault(LottoResult.FIVE_BONUS, 0), "5개 + 보너스 일치 통계가 예상과 다릅니다.");
    }
}