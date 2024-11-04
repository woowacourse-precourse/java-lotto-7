package lotto.basic.results;

import lotto.checker.domain.BonusNumber;
import lotto.checker.domain.Lotto;
import lotto.checker.domain.WinningNumbers;
import lotto.purchase.domain.Money;
import lotto.results.application.ResultsService;
import lotto.results.domain.Result;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckTest {

    @Test
    void 번호_맞추기_당첨번호_테스트() {
        // given
        ResultsService resultsService = new ResultsService();
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Integer expectedValues = 3;

        // when
        Integer actualValue = resultsService.countWinningNumber(winningNumbers, lotto);

        // then
        assertThat(actualValue)
                .isEqualTo(expectedValues);
    }

    @Test
    void 번호_맞추기_보너스번호_테스트() {
        // given
        ResultsService resultsService = new ResultsService();
        WinningNumbers winningNumbers = new WinningNumbers("31, 32, 33, 34, 35, 36");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 7));
        Integer expectedValues = 1;

        // when
        Integer actualValue = resultsService.countBonusNumber(bonusNumber.value(), lotto);

        // then
        assertThat(actualValue)
                .isEqualTo(expectedValues);
    }

    @Test
    void 수익률_계산_테스트() {
        // given
        Money money = new Money("1000");
        Result result = Result.FIFTH;
        double expectedValues = 500.0;

        // when
        double actualValue = result.getROI(money);

        // then
        assertThat(actualValue).isEqualTo(expectedValues);
    }
}
