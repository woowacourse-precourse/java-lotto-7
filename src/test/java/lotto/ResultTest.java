package lotto;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    @DisplayName("당첨번호와 발급된 로또를 비교해서 당첨금액을 계산한다.")
    @Test
    void 당첨결과_금액_계산_테스트() {
        LottoMachine testMachine = new LottoMachine();
        testMachine.gameResult.flushCount();
        List<List<Integer>> testLottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 8),
                List.of(16, 17, 18, 19, 20, 21));
        Lottos testLottos = new Lottos(testLottoNumbers);
        WinningNumbers testWinningNumbers = new WinningNumbers(List.of("1", "2", "3", "4", "5", "6"));
        BonusNumber testBonusNumber = new BonusNumber(List.of("9"));

        testMachine.calculateResults(testLottos, testWinningNumbers, testBonusNumber);
        Assertions.assertEquals(1500000, testMachine.gameResult.totalPrize());
    }
}
