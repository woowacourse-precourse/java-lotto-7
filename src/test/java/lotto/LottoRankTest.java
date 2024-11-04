package lotto;

import lotto.domain.result.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("당첨 번호 개수와 보너스 번호 일치 여부로 등수를 반환한다")
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
    void getLottoRankByMatch(int matchCount, boolean hasBonusNumber, LottoRank expected) {
        assertThat(LottoRank.of(matchCount, hasBonusNumber)).isEqualTo(expected);
    }

    @DisplayName("당첨금을 정확하게 반환한다")
    @Test
    void getPrizeMoney() {
        assertThat(LottoRank.FIRST.getPrizeMoney().getAmount()).isEqualTo(2_000_000_000);
        assertThat(LottoRank.SECOND.getPrizeMoney().getAmount()).isEqualTo(30_000_000);
        assertThat(LottoRank.THIRD.getPrizeMoney().getAmount()).isEqualTo(1_500_000);
        assertThat(LottoRank.FOURTH.getPrizeMoney().getAmount()).isEqualTo(50_000);
        assertThat(LottoRank.FIFTH.getPrizeMoney().getAmount()).isEqualTo(5_000);
        assertThat(LottoRank.NONE.getPrizeMoney().getAmount()).isEqualTo(0);
    }
}