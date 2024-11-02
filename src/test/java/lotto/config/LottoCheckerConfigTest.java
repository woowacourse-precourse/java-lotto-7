package lotto.config;

import static org.junit.jupiter.api.Assertions.*;

import lotto.controller.LottoCheckerController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckerConfigTest {

    @Test
    @DisplayName("LottoCheckerController 객체가 싱글톤 객체인지 확인")
    void getLottoCheckerControllerTest() {
        LottoCheckerController expected = LottoCheckerConfig.lottoCheckerController;

        assertEquals(
                LottoCheckerConfig.getLottoCheckerController().hashCode(),
                expected.hashCode()
        );
    }
}