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

        //then
        assertThat(statistics).containsExactly(0, 0, 0, 0, 1);
    }

    @Test
    @DisplayName("통계 계산 - 3개 번호 일치")
    void 통계_계산_3개_일치() {
        //given
        int validMoney = 2000;
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 15, 16, 17)),
                new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9))
        );
        Money money = new Money(validMoney);
        Lottos lottos = new Lottos(validLottos);
        User user = new User(money, lottos);

        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        //when
        List<Integer> statistics = StatisticCalculator.calculateStatistics(user, winningNumber);

        //then
        assertThat(statistics).containsExactly(2, 0, 0, 0, 0);
    }

    @Test
    @DisplayName("통계 계산 - 4개 번호 일치")
    void 통계_계산_4개_일치() {
        //given
        int validMoney = 2000;
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 15, 16)),
                new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10))
        );
        Money money = new Money(validMoney);
        Lottos lottos = new Lottos(validLottos);
        User user = new User(money, lottos);

        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        //when
        List<Integer> statistics = StatisticCalculator.calculateStatistics(user, winningNumber);

        //then
        assertThat(statistics).containsExactly(0, 1, 0, 0, 0);
    }

    @Test
    @DisplayName("통계 계산 - 5개 번호 일치(보너스 번호 포함)")
    void 통계_계산_5개_일치_보너스포함() {
        //given
        int validMoney = 2000;
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13))
        );
        Money money = new Money(validMoney);
        Lottos lottos = new Lottos(validLottos);
        User user = new User(money, lottos);

        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        //when
        List<Integer> statistics = StatisticCalculator.calculateStatistics(user, winningNumber);

        //then
        assertThat(statistics).containsExactly(0, 0, 0, 1, 0);
    }

    @Test
    @DisplayName("통계 계산 - 5개 번호 일치(보너스 번호 불일치)")
    void 통계_계산_5개_일치_보너스불일치() {
        //given
        int validMoney = 2000;
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14))
        );
        Money money = new Money(validMoney);
        Lottos lottos = new Lottos(validLottos);
        User user = new User(money, lottos);

        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        //when
        List<Integer> statistics = StatisticCalculator.calculateStatistics(user, winningNumber);

        //then
        assertThat(statistics).containsExactly(0, 0, 1, 0, 0);
    }

    @Test
    @DisplayName("통계 계산 - 모든 번호 일치")
    void 통계_계산_모든번호일치() {
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

        //then
        assertThat(statistics).containsExactly(0, 0, 0, 0, 1);
    }

    @Test
    @DisplayName("통계 계산 - 일치하는 번호가 없는 경우")
    void 통계_계산_번호불일치() {
        //given
        int validMoney = 2000;
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
        );
        Money money = new Money(validMoney);
        Lottos lottos = new Lottos(validLottos);
        User user = new User(money, lottos);

        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        //when
        List<Integer> statistics = StatisticCalculator.calculateStatistics(user, winningNumber);

        //then
        assertThat(statistics).containsExactly(0, 0, 0, 0, 0);
    }
}
