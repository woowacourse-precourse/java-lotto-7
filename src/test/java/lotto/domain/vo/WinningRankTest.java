package lotto.domain.vo;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningRankTest {

    @DisplayName("당첨 번호 개수와 보너스 번호 일치 여부에 따라 알맞은 등수를 반환한다")
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
    void of_ShouldReturnCorrectRank(int matchCount, boolean isBonusMatch, WinningRank expectedRank) {
        WinningRank actualRank = WinningRank.of(matchCount, isBonusMatch);

        assertThat(actualRank).isEqualTo(expectedRank);
    }

    @DisplayName("당첨금 정보를 정확히 반환한다")
    @ParameterizedTest
    @CsvSource({
        "FIRST, 2000000000",
        "SECOND, 30000000",
        "THIRD, 1500000",
        "FOURTH, 50000",
        "FIFTH, 5000",
        "NONE, 0"
    })
    void getPrizeMoney_ShouldReturnCorrectAmount(WinningRank rank, int expectedPrizeMoney) {
        int actualPrizeMoney = rank.getPrizeMoney();

        assertThat(actualPrizeMoney).isEqualTo(expectedPrizeMoney);
    }

    @DisplayName("당첨 메시지를 형식에 맞게 반환한다")
    @Test
    void getWinningMessage_ShouldReturnFormattedMessage() {
        int winningCount = 1;
        WinningRank rank = WinningRank.FIRST;

        String message = rank.getWinningMessage(winningCount);

        assertAll(
            () -> assertTrue(message.contains("6개")),
            () -> assertTrue(message.contains("2,000,000,000")),
            () -> assertTrue(message.contains(String.valueOf(winningCount)))
        );
    }
}