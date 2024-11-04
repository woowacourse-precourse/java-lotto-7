package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class LottoResultCalculatorTest {

    LottoResultCalculator calculator = new LottoResultCalculator();

    @Test
    void HashMap에_각_당첨레벨에_대해_올바르게_초기화_되는지_기능테스트() {
        HashMap<LottoResultCalculator.WinningLevel, Integer> matches = calculator.prepareResultStorage();
        for(LottoResultCalculator.WinningLevel level : LottoResultCalculator.WinningLevel.values()) {
            assertEquals(0, matches.get(level));
        }
    }
}
