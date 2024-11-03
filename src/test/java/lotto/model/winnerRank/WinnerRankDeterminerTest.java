package lotto.model.winnerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class WinnerRankDeterminerTest {
    @ParameterizedTest
    @DisplayName("[success] 일치 개수와 보너스 번호 일치 여부를 확인하고 해당하는 당첨 등수를 반환한다.")
    @MethodSource("lottoWithWinningRankProvider")
    void findWinningRankByMatchingAmountAndBonusNumber(WinnerRank expectedWinnerRank, int matchingAmount,
                                                       List<Integer> numbers) {
        WinnerRankDeterminer winnerRankDeterminer = new WinnerRankDeterminer();
        int bonusNumber = 7;
        boolean matchesBonusNumber = numbers.contains(bonusNumber);

        Assertions.assertThat(winnerRankDeterminer.determine(matchingAmount, matchesBonusNumber))
                .isEqualTo(expectedWinnerRank);
    }
    static Stream<Object[]> lottoWithWinningRankProvider() {
        return Stream.of(
                new Object[]{WinnerRank.FIRST, 6, Arrays.asList(1, 2, 3, 4, 5, 6)},
                new Object[]{WinnerRank.SECOND, 5, Arrays.asList(1, 2, 3, 4, 5, 7)},
                new Object[]{WinnerRank.THIRD, 5, Arrays.asList(1, 2, 3, 4, 5, 8)},
                new Object[]{WinnerRank.FOURTH, 4, Arrays.asList(1, 2, 3, 4, 8, 9)},
                new Object[]{WinnerRank.FIFTH, 3, Arrays.asList(1, 2, 3, 8, 9, 10)},
                new Object[]{WinnerRank.FAIL, 2, Arrays.asList(1, 2, 8, 9, 10, 11)},
                new Object[]{WinnerRank.FAIL, 1, Arrays.asList(1, 8, 9, 10, 11, 12)},
                new Object[]{WinnerRank.FAIL, 0, Arrays.asList(8, 9, 10, 11, 12, 13)}
        );
    }
}
