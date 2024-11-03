package lotto.test;

import lotto.service.WinningNumberPool;
import lotto.test.domainTest.DrawNumberTest;
import lotto.test.domainTest.IssueRandomLottoTest;
import lotto.test.domainTest.LottoPoolTest;
import lotto.test.serviceTest.*;
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
    public void testIssueRandomLotto(){
        new IssueRandomLottoTest().testMakeRandomLottoAndGetLotto();
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
    public void testWinningNumberPool(){
        new WinningNumberPoolTest().run();
    }

    @Test
    public void testWinningStatisticsManager(){
        new WinningStatisticsManagerTest().run();
    }
}
