package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

class LottoResultTest {
    @DisplayName("당첨 결과와 수익률을 정확하게 계산한다.")
    @Test
    void calculateLottoResultAndReturnRate() {
        // given
        // 3개 일치하는 로또 1개와 나머지 4개는 일치하는 번호 없음
        List<Integer> expectedNumbers1 = Arrays.asList(1, 2, 3, 7, 8, 9);        // 3개 일치
        List<Integer> expectedNumbers2 = Arrays.asList(7, 8, 9, 10, 11, 12);     // 미당첨
        List<Integer> expectedNumbers3 = Arrays.asList(13, 14, 15, 16, 17, 18);  // 미당첨
        List<Integer> expectedNumbers4 = Arrays.asList(19, 20, 21, 22, 23, 24);  // 미당첨
        List<Integer> expectedNumbers5 = Arrays.asList(25, 26, 27, 28, 29, 30);  // 미당첨

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = Lottos.autoGenerate(5);
                    WinningNumbers winningNumbers = WinningNumbers.of(
                            Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                            BonusNumber.from(7)
                    );
                    LottoResult lottoResult = new LottoResult();

                    // when
                    lottoResult.calculateResult(lottos, winningNumbers);
                    double returnRate = lottoResult.calculateReturnRate(5000);

                    // then
                    Map<WinningPrize, Integer> results = lottoResult.getResults();
                    assertThat(results.get(WinningPrize.FIFTH_PRIZE)).isEqualTo(1);
                    assertThat(results.get(WinningPrize.FOURTH_PRIZE)).isEqualTo(0);
                    assertThat(results.get(WinningPrize.THIRD_PRIZE)).isEqualTo(0);
                    assertThat(results.get(WinningPrize.SECOND_PRIZE)).isEqualTo(0);
                    assertThat(results.get(WinningPrize.FIRST_PRIZE)).isEqualTo(0);


                    assertThat(returnRate).isEqualTo(100.0);
                },
                expectedNumbers1,
                expectedNumbers2,
                expectedNumbers3,
                expectedNumbers4,
                expectedNumbers5
        );
    }

    @DisplayName("당첨 결과가 정확하게 기록된다.")
    @Test
    void recordWinningResult() {
        // given
        List<Integer> threeMatch = Arrays.asList(1, 2, 3, 7, 8, 9);         // 3개 일치
        List<Integer> fourMatch = Arrays.asList(1, 2, 3, 4, 8, 9);          // 4개 일치
        List<Integer> fiveMatch = Arrays.asList(1, 2, 3, 4, 5, 9);          // 5개 일치
        List<Integer> fiveMatchWithBonus = Arrays.asList(1, 2, 3, 4, 5, 7); // 5개 + 보너스
        List<Integer> sixMatch = Arrays.asList(1, 2, 3, 4, 5, 6);           // 6개 일치

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    // when
                    Lottos lottos = Lottos.autoGenerate(5); // 5개의 로또 생성
                    LottoResult lottoResult = new LottoResult();
                    WinningNumbers winningNumbers = WinningNumbers.of(
                            Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                            BonusNumber.from(7)
                    );

                    lottoResult.calculateResult(lottos, winningNumbers);
                    Map<WinningPrize, Integer> results = lottoResult.getResults();

                    // then
                    assertThat(results.get(WinningPrize.FIFTH_PRIZE)).isEqualTo(1);    // 3개 일치
                    assertThat(results.get(WinningPrize.FOURTH_PRIZE)).isEqualTo(1);   // 4개 일치
                    assertThat(results.get(WinningPrize.THIRD_PRIZE)).isEqualTo(1);    // 5개 일치
                    assertThat(results.get(WinningPrize.SECOND_PRIZE)).isEqualTo(1);   // 5개 + 보너스
                    assertThat(results.get(WinningPrize.FIRST_PRIZE)).isEqualTo(1);    // 6개 일치
                },
                threeMatch, fourMatch, fiveMatch, fiveMatchWithBonus, sixMatch
        );
    }
}