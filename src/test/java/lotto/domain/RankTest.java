package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("당첨 번호 개수와 보너스 번호 일치 여부에 따라 등수를 정확히 반환한다")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, NONE",
            "1, false, NONE",
            "0, false, NONE"
    })
    void valueOf(int matchCount, boolean matchBonus, Rank expected) {
        assertThat(Rank.valueOf(matchCount, matchBonus)).isEqualTo(expected);
    }

    @DisplayName("당첨금을 정확히 반환한다")
    @Test
    void getPrize() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
    }

    @DisplayName("당첨 설명을 정확히 반환한다")
    @Test
    void getDescription() {
        assertThat(Rank.FIRST.getDescription()).isEqualTo("6개 일치 (2,000,000,000원)");
        assertThat(Rank.SECOND.getDescription()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
        assertThat(Rank.THIRD.getDescription()).isEqualTo("5개 일치 (1,500,000원)");
    }
}