package lotto.statistics;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchCounterTest {

    @DisplayName("3개 일치하면 카운터 3번의 값이 증가한다.")
    @Test
    void shouldIncreaseCounter3WhenMatchNumber3() {
        // give
        MatchCounter matchCounter = new MatchCounter();
        int matchedNumber = 3;
        boolean matchedBonusResult = false;
        int expectedCounterResult = 1;

        // when
        matchCounter.updateMatchResult(matchedNumber, matchedBonusResult);

        // then
        Assertions.assertThat(matchCounter.getMatchedNumbers().get(3)).isEqualTo(expectedCounterResult);
    }

    @DisplayName("5개 일치하고 보너스 번호가 일치하지 않으면 카운터 5번의 값이 증가한다.")
    @Test
    void shouldIncreaseCounter5WhenMatchNumber5AndHasNotBonus() {
        // give
        MatchCounter matchCounter = new MatchCounter();
        int matchedNumber = 5;
        boolean matchedBonusResult = false;
        int expectedCounterResult = 1;

        // when
        matchCounter.updateMatchResult(matchedNumber, matchedBonusResult);

        // then
        Assertions.assertThat(matchCounter.getMatchedNumbers().get(5)).isEqualTo(expectedCounterResult);
    }

    @DisplayName("5개 일치하고 보너스 번호가 일치하면 카운터 6번의 값이 증가한다.")
    @Test
    void shouldIncreaseCounter6WhenMatchNumber5AndHasBonus() {
        // give
        MatchCounter matchCounter = new MatchCounter();
        int matchedNumber = 5;
        boolean matchedBonusResult = true;
        int expectedCounterResult = 1;

        // when
        matchCounter.updateMatchResult(matchedNumber, matchedBonusResult);

        // then
        Assertions.assertThat(matchCounter.getMatchedNumbers().get(6)).isEqualTo(expectedCounterResult);
    }

    @DisplayName("6개 일치하면 카운터 7번의 값이 증가한다.")
    @Test
    void shouldIncreaseCounter7WhenMatchNumber6() {
        // give
        MatchCounter matchCounter = new MatchCounter();
        int matchedNumber = 6;
        boolean matchedBonusResult = false;
        int expectedCounterResult = 1;

        // when
        matchCounter.updateMatchResult(matchedNumber, matchedBonusResult);

        // then
        Assertions.assertThat(matchCounter.getMatchedNumbers().get(7)).isEqualTo(expectedCounterResult);
    }
}
