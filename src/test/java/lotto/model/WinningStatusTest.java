package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningStatusTest {

    @ParameterizedTest
    @CsvSource({
            "3, false, THREE_MATCHES",
            "4, false, FOUR_MATCHES",
            "5, false, FIVE_MATCHES",
            "5, true, FIVE_MATCHES_WITH_BONUS",
            "6, false, SIX_MATCHES",
            "2, false, NO_WIN"
    })
    @DisplayName("맞춘 개수와 보너스 번호 일치 여부에 따라 적절한 당첨 상태를 반환한다")
    void getWinningStatus(int matchCount, boolean isBonusMatch, WinningStatus expected) {
        // when
        WinningStatus status = WinningStatus.getWinningStatus(matchCount, isBonusMatch);

        // then
        assertThat(status).isEqualTo(expected);
    }
}
