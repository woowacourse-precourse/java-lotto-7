package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 로또_결과_카운트() {

        //Given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> purchasedLotto = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), //6개 일치(1등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), //5개 + 보너스 일치(2등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), //5개 일치(3등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), //4개 일치(4등)
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)) //3개 일치(5등)
        );
        Calculator calculator = new Calculator(winningNumbers);

        // When
        Map<Ranking, Long> results = calculator.lottoResults(purchasedLotto);
        double returnRate = calculator.calculateReturnRate(results, purchasedLotto.size());

        //Then
        assertThat(results.get(Ranking.PICK3)).isEqualTo(1L);
        assertThat(results.get(Ranking.PICK4)).isEqualTo(1L);
        assertThat(results.get(Ranking.PICK5_WITH_BONUS)).isEqualTo(1L);
        assertThat(results.get(Ranking.PICK6)).isEqualTo(1L);
        assertThat(returnRate).isGreaterThan(0); // 반환율이 0보다 커야 함

    }
}
