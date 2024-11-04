package lotto.model.rank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.dto.MatchingResultDto;
import lotto.model.lotto.winningResult.rank.DefaultRankDeterminer;
import lotto.model.lotto.winningResult.rank.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class DefaultRankDeterminerTest {
    @ParameterizedTest
    @DisplayName("[success] 일치 개수와 보너스 번호 일치 여부를 확인하고 해당하는 당첨 등수를 반환한다.")
    @MethodSource("lottoWithWinningRankProvider")
    void findWinningRankByMatchingAmountAndBonusNumber(Rank expectedRank, int matchingAmount,
                                                       List<Integer> numbers) {
        DefaultRankDeterminer defaultRankDeterminer = new DefaultRankDeterminer();
        int bonusNumber = 7;
        boolean matchesBonusNumber = numbers.contains(bonusNumber);

        Assertions.assertThat(
                        defaultRankDeterminer.determine(new MatchingResultDto(matchingAmount, matchesBonusNumber)))
                .isEqualTo(expectedRank);
    }

    static Stream<Object[]> lottoWithWinningRankProvider() {
        return Stream.of(
                new Object[]{Rank.FIRST, 6, Arrays.asList(1, 2, 3, 4, 5, 6)},
                new Object[]{Rank.SECOND, 5, Arrays.asList(1, 2, 3, 4, 5, 7)},
                new Object[]{Rank.THIRD, 5, Arrays.asList(1, 2, 3, 4, 5, 8)},
                new Object[]{Rank.FOURTH, 4, Arrays.asList(1, 2, 3, 4, 8, 9)},
                new Object[]{Rank.FIFTH, 3, Arrays.asList(1, 2, 3, 8, 9, 10)},
                new Object[]{Rank.FAIL, 2, Arrays.asList(1, 2, 8, 9, 10, 11)},
                new Object[]{Rank.FAIL, 1, Arrays.asList(1, 8, 9, 10, 11, 12)},
                new Object[]{Rank.FAIL, 0, Arrays.asList(8, 9, 10, 11, 12, 13)}
        );
    }
}
