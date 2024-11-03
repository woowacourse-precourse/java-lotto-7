package lotto;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    @DisplayName("당첨번호와 발급된 로또를 비교해서 당첨금액을 계산한다.")
    @Test
    void 당첨결과_금액_계산_테스트() {
        Lottos testLottos = new Lottos(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12)));
        WinningNumbers testWinningNumbers = new WinningNumbers(List.of("1", "2", "3", "4", "5", "8"));
        BonusNumber testBonusNumber = new BonusNumber(List.of("9"));
        LottoMachine testMachine = new LottoMachine();
        int expectedPrize = 1500000;

        testMachine.calculateResults(testLottos, testWinningNumbers, testBonusNumber);
        Assertions.assertEquals(expectedPrize, Result.totalPrize());
    }
}
