package lotto.utils.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.utils.Calculator.StatisticCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticCalculatorTest {

    @Test
    @DisplayName("통계 계산 - 정상적인 경우")
    void 통계_계산_정상_검증() {
        //given
        int validMoney = 2000;
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        Money money = new Money(validMoney);
        Lottos lottos = new Lottos(validLottos);
        User user = new User(money, lottos);

        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        //when
        List<Integer> statistics = StatisticCalculator.calculateStatistics(user, winningNumber);

        // Then
        assertThat(statistics).containsExactly(0, 0, 0, 0, 1);
    }
}
