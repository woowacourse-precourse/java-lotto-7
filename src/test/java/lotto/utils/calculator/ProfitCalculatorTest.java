package lotto.utils.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.utils.Calculator.ProfitCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산이 정상 수행 검증")
    void 수익률_계산_정상_수행_검증() {
        //given
        int money = 10000;
        Money investMoney = new Money(money);
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(validLottos);
        User user = new User(investMoney, lottos);

        List<Integer> winningResult = Arrays.asList(0, 1, 1, 0, 0);
        //when
        double profit = ProfitCalculator.calculateProfit(user, winningResult);

        //then
        assertThat(profit).isEqualTo(15500.0);

    }
}
