package lotto.test;

import lotto.test.domainTest.DrawNumberTest;
import lotto.test.domainTest.LottoPoolTest;
import lotto.test.serviceTest.LottoConverterTest;
import lotto.test.serviceTest.ValidCheckerTest;
import lotto.test.serviceTest.WinningNumberCheckerTest;
import lotto.test.serviceTest.WinningStatisticsManagerTest;
import org.junit.jupiter.api.Test;

public class WholeTest {
    @Test
    public void testDrawNumber() {
        new DrawNumberTest().testDraw();
    }

    @Test
    public void testLottoPool(){
        new LottoPoolTest().run();
    }

    @Test
    public void testLottoConverter(){
        new LottoConverterTest().run();
    }

    @Test
    public void testValidChecker(){
        new ValidCheckerTest().run();
    }

    @Test
    public void testWinningNumberChecker(){
        new WinningNumberCheckerTest().run();
    }

    @Test
    public void testWinningStatisticsManager(){
        new WinningStatisticsManagerTest().run();
    }
}
