package lotto.service;

import lotto.util.NumberUtil;
import lotto.view.InputView;
import lotto.view.TestInputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorServiceTest {

    private LottoGeneratorService lottoGeneratorService;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        lottoGeneratorService = new LottoGeneratorService(inputView);
    }


    @Test
    void 천원단위_아닐시_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoGeneratorService.checkThousandUnit(1500);
        });
        assertEquals("[ERROR] 구입금액은 1000원 단위여야 합니다.", exception.getMessage());
    }

    @Test
    void 천원단위일시_참_반환() {
        boolean result = lottoGeneratorService.checkThousandUnit(10000);
        assertTrue(result);
    }

    @Test
    void 잘못된_값_입력시_다시_입력요청후_1000반환() {
        TestInputView testInputView = new TestInputView("-10", "0", "abc", "1500", "1000");
        LottoGeneratorService lottoGeneratorService = new LottoGeneratorService(testInputView);
        int result = lottoGeneratorService.lottoPurchase();
        assertEquals(1000, result);
    }

    @Test
    void 금액_입력시_구매한_로또갯수_반환() {
        int result = lottoGeneratorService.calculateLottoCount(15000);
        assertEquals(15, result);
    }
}