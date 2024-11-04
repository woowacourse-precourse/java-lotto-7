package lotto.service;

import lotto.util.NumberUtil;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorServiceTest {

    private LottoGeneratorService lottoGeneratorService;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView(); // InputView도 필드로 선언하고 초기화
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
    void 천원단위일시_참_반환(){
        boolean result = lottoGeneratorService.checkThousandUnit(10000);
        assertTrue(result);
    }
}