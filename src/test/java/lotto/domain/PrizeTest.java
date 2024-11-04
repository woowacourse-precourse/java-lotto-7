package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {
    @DisplayName("일치하는 번호 개수와 보너스 번호 일치 여부에 따라 올바른 상금을 반환한다")
    @ParameterizedTest
    @CsvSource({
        "6, false, 2000000000", // 1등
        "5, true, 30000000",    // 2등
        "5, false, 1500000",    // 3등
        "4, false, 50000",      // 4등
        "3, false, 5000",       // 5등
        "2, false, 0",          // 미당첨
        "1, false, 0",          // 미당첨
        "0, false, 0"           // 미당첨
    })
    void prizeAmount(int matchCount, boolean hasBonusNumber, int expectedPrize) {
        Prize prize = Prize.of(matchCount, hasBonusNumber);
        assertThat(prize.getPrize()).isEqualTo(expectedPrize);
    }

    @DisplayName("당첨 등수에 따라 올바른 설명을 반환한다")
    @Test
    void prizeDescription() {
        assertThat(Prize.FIRST.getDescription()).isEqualTo("6개 일치");
        assertThat(Prize.SECOND.getDescription()).isEqualTo("5개 일치, 보너스 볼 일치");
        assertThat(Prize.THIRD.getDescription()).isEqualTo("5개 일치");
        assertThat(Prize.FOURTH.getDescription()).isEqualTo("4개 일치");
        assertThat(Prize.FIFTH.getDescription()).isEqualTo("3개 일치");
    }

    @DisplayName("5개 일치시 보너스 번호 일치 여부에 따라 2등과 3등을 구분한다")
    @Test
    void secondAndThirdPrize() {
        assertThat(Prize.of(5, true)).isEqualTo(Prize.SECOND);
        assertThat(Prize.of(5, false)).isEqualTo(Prize.THIRD);
    }

    @DisplayName("3개 미만 일치시 NONE을 반환한다")
    @ParameterizedTest
    @CsvSource({
        "2, false",
        "1, false",
        "0, false"
    })
    void noPrize(int matchCount, boolean hasBonusNumber) {
        assertThat(Prize.of(matchCount, hasBonusNumber)).isEqualTo(Prize.NONE);
    }
}