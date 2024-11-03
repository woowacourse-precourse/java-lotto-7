package lotto.model.winnerRank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class WinnerRankTest {
    @Test
    @DisplayName("[success] 1~5등에 해당하는 등수 리스트를 반환한다.")
    void findWinningRankListExceptFail() {
        List<WinnerRank> winnerRanksExceptFail = WinnerRank.findRanksExceptFail();

        assertThat(winnerRanksExceptFail.size()).isEqualTo(5);
        assertThat(winnerRanksExceptFail.contains(WinnerRank.FAIL)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("[success] 등수(1~6) 숫자에 맞는 WinnerRank를 반환한다.")
    @CsvSource(value = {"1:FIRST", "2:SECOND", "3:THIRD", "4:FOURTH", "5:FIFTH", "6:FAIL", "7:FAIL"}
            , delimiter = ':')
    void findWinningRankByRank(int rank, WinnerRank expectedWinnerRank) {
        WinnerRank winnerRank = WinnerRank.findByRank(rank);

        assertThat(winnerRank).isEqualTo(expectedWinnerRank);
    }

    @Test
    @DisplayName("[fail] 반환된 리스트를 수정하는 경우 예외가 발생한다.")
    void fail_IfModifyWinningRankList() {
        List<WinnerRank> winnerRanks = WinnerRank.findRanksExceptFail();

        assertThatThrownBy(() -> winnerRanks.add(WinnerRank.FAIL))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> winnerRanks.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
