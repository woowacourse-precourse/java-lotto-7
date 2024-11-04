package lotto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.model.LottoTicket;
import lotto.service.LottoNumberGenerator;
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
        LottoNumberGenerator generator = new LottoNumberGenerator(); // LottoNumberGenerator 인스턴스 생성
        lottoService = new LottoService(generator);
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
    @DisplayName("잘못된 입력에 대한 예외 처리가 적절히 수행되는지 테스트")
    void testInvalidPurchaseAmount() {
        String invalidPurchaseAmount = "invalid_input";

        assertThrows(IllegalArgumentException.class, () -> {
            PurchaseValidator.validatePurchaseAmount(invalidPurchaseAmount);
        });
    }
}
