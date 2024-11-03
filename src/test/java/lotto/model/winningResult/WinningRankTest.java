package lotto.model.winningResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningRankTest {
    @ParameterizedTest
    @DisplayName("[success] 일치 개수와 보너스 번호 일치 여부를 확인하고 해당하는 당첨 등수를 반환한다.")
    @MethodSource("lottoWithWinningRankProvider")
    void findWinningRankByMatchingAmountAndBonusNumber(WinningRank expectedWinningRank, int matchingAmount,
                                                       List<Integer> numbers) {
        int bonusNumber = 7;
        boolean matchesBonusNumber = numbers.contains(bonusNumber);

        assertThat(WinningRank.determineRank(matchingAmount, matchesBonusNumber))
                .isEqualTo(expectedWinningRank);
    }
    static Stream<Object[]> lottoWithWinningRankProvider() {
        return Stream.of(
                new Object[]{WinningRank.FIRST, 6, Arrays.asList(1, 2, 3, 4, 5, 6)},
                new Object[]{WinningRank.SECOND, 5, Arrays.asList(1, 2, 3, 4, 5, 7)},
                new Object[]{WinningRank.THIRD, 5, Arrays.asList(1, 2, 3, 4, 5, 8)},
                new Object[]{WinningRank.FOURTH, 4, Arrays.asList(1, 2, 3, 4, 8, 9)},
                new Object[]{WinningRank.FIFTH, 3, Arrays.asList(1, 2, 3, 8, 9, 10)},
                new Object[]{WinningRank.FAIL, 2, Arrays.asList(1, 2, 8, 9, 10, 11)},
                new Object[]{WinningRank.FAIL, 1, Arrays.asList(1, 8, 9, 10, 11, 12)},
                new Object[]{WinningRank.FAIL, 0, Arrays.asList(8, 9, 10, 11, 12, 13)}
        );
    }

    @Test
    @DisplayName("[success] 1~5등에 해당하는 등수 리스트를 반환한다.")
    void findWinningRankListExceptFail() {
        List<WinningRank> winningRanksExceptFail = WinningRank.findRanksExceptFail();

        assertThat(winningRanksExceptFail.size()).isEqualTo(5);
        assertThat(winningRanksExceptFail.contains(WinningRank.FAIL)).isFalse();
    }

    @Test
    @DisplayName("[fail] 반환된 리스트를 수정하는 경우 예외가 발생한다.")
    void fail_IfModifyWinningRankList() {
        List<WinningRank> winningRanks = WinningRank.findRanksExceptFail();

        assertThatThrownBy(() -> winningRanks.add(WinningRank.FAIL))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> winningRanks.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
