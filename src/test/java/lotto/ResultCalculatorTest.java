package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultCalculatorTest {
    private ResultCalculator resultCalculator;
    private LottoMatcher lottoMatcher;

    @BeforeEach
    void setUp() {
        lottoMatcher = new LottoMatcher(); // LottoMatcher의 인스턴스를 생성
        resultCalculator = new ResultCalculator(lottoMatcher);
    }

    @Test
    @DisplayName("매치가 없는 경우 결과를 계산한다.")
    void testCalculateResult_WithNoMatches() {
        List<Lotto> lottos = Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = Arrays.asList(7, 8, 9, 10,11);
        int bonusNumber = 12;

        int[] result = resultCalculator.calculateResult(lottos, winningNumbers, bonusNumber);

        assertThat(result[Rank.NONE.ordinal()]).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호가 맞고 보너스 번호가 맞는 경우 결과를 계산한다.")
    void testCalculateResult_WithFiveMatchesAndBonus() {
        List<Lotto> lottos = Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int[] result = resultCalculator.calculateResult(lottos, winningNumbers, bonusNumber);

        assertThat(result[Rank.NONE.ordinal()]).isEqualTo(0);
        assertThat(result[Rank.SECOND.ordinal()]).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호가 맞고 보너스 번호가 맞지 않는 경우 결과를 계산한다.")
    void testCalculateResult_WithFiveMatchesWithoutBonus() {
        List<Lotto> lottos = Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 8; // 보너스 번호가 맞지 않음

        int[] result = resultCalculator.calculateResult(lottos, winningNumbers, bonusNumber);

        assertThat(result[Rank.NONE.ordinal()]).isEqualTo(0);
        assertThat(result[Rank.THIRD.ordinal()]).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void testCalculateProfit() {
        int[] result = {1, 0, 0, 0, 0, 0}; // 1등이 1개
        int payment = 10000; // 총 지출 금액

        // 1등 보상이 20000이라면
        float expectedProfit = 19999999f;
        float profit = resultCalculator.calculateProfit(result, payment);

        assertEquals(expectedProfit, profit, 0.01f);
    }

    @Test
    @DisplayName("결과가 없는 경우 수익률을 계산한다.")
    void testCalculateProfit_WithNoResults() {
        int[] result = new int[Rank.values().length];
        int payment = 10000;

        float profit = resultCalculator.calculateProfit(result, payment);

        assertEquals(0.0f, profit);
    }

    @Test
    @DisplayName("로또 번호 개수가 유효하지 않은 경우 예외가 발생한다.")
    void testLottoCreation_WithInvalidSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(1, 2, 3));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });
    }
}
