package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTests {

    @ParameterizedTest
    @DisplayName("구매한 로또 번호와 당첨 번호, 보너스 번호를 활용하여 등수를 산정")
    @MethodSource("provideArguments")
    void findRankTest(List<Integer> winningNumbers, Integer bonusNumber, LottoRank expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int sameCount = lotto.countSameNumber(winningNumbers);
        boolean isSecond = lotto.isSecondRank(winningNumbers, bonusNumber);

        assertEquals(LottoRank.findRank(sameCount, isSecond), expected);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 7, 8, 9, 10), 6, LottoRank.NONE),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 6, LottoRank.FIFTH),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), 6, LottoRank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 8, LottoRank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 6, LottoRank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, LottoRank.FIRST)
        );
    }
}