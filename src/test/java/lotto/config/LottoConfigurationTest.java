package lotto.config;

import lotto.input.InputHandler;
import lotto.input.InputParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoConfigurationTest {
    private static class FixedInputHandler extends InputHandler {
        @Override
        public int inputPurchaseAmount() {
            return 8000;
        }
        @Override
        public String inputWinningNumbers() {
            return "1, 2, 3, 4, 5, 6";
        }
        @Override
        public int inputBonusNumber() {
            return 7;
        }
    }
    private static class FixedInputParser extends InputParser {
        @Override
        public List<Integer> splitWinningNumbers(String winningNumbers) {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }

    @Test
    void 로또_초기설정_테스트() {
        InputHandler inputHandler = new FixedInputHandler();
        InputParser inputParser = new FixedInputParser();
        LottoConfiguration lottoConfiguration = new LottoConfiguration(inputHandler, inputParser);
        assertEquals(8000, lottoConfiguration.lottoPrice());
        assertEquals(8, lottoConfiguration.lottoCount());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), lottoConfiguration.winningNumbers());
        assertEquals(8, lottoConfiguration.lottos().size());
        assertEquals(7, lottoConfiguration.bonusNumber());
    }
}