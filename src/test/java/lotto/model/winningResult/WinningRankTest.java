package lotto.model.winningResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningRankTest {
    @ParameterizedTest
    @MethodSource("lottoWithWinningRankProvider")
    void 로또의_당첨_등수를_확인한다(WinningRank expectedWinningRank, int matchingAmount, List<Integer> numbers) {
        int bonusNumber = 7;
        boolean matchesBonusNumber = numbers.contains(bonusNumber);

        Assertions.assertThat(WinningRank.determineRank(matchingAmount, matchesBonusNumber))
                .isEqualTo(expectedWinningRank);
    }
    static Stream<Object[]> lottoWithWinningRankProvider() {
        return Stream.of(
                new Object[]{WinningRank.FIRST, 6, Arrays.asList(1, 2, 3, 4, 5, 6)}, //6개 일치
                new Object[]{WinningRank.SECOND, 5, Arrays.asList(1, 2, 3, 4, 5, 7)}, //5개 일치
                new Object[]{WinningRank.THIRD, 5, Arrays.asList(1, 2, 3, 4, 5, 8)}, //5개 일치
                new Object[]{WinningRank.FOURTH, 4, Arrays.asList(1, 2, 3, 4, 8, 9)}, //4개 일치
                new Object[]{WinningRank.FIFTH, 3, Arrays.asList(1, 2, 3, 8, 9, 10)}, //3개 일치
                new Object[]{WinningRank.FAIL, 2, Arrays.asList(1, 2, 8, 9, 10, 11)}, //2개 일치
                new Object[]{WinningRank.FAIL, 1, Arrays.asList(1, 8, 9, 10, 11, 12)}, //1개 일치
                new Object[]{WinningRank.FAIL, 0, Arrays.asList(8, 9, 10, 11, 12, 13)} //0개 일치
        );
    }
}
