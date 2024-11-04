package lotto.domain.winning;

import static lotto.domain.lotto.LottoFactory.createCustomLotto;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.number.Number;
import lotto.domain.number.NumberFactory;
import lotto.domain.number.Numbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMatcherTest {
    private LottoMatcher lottoMatcher;
    private WinningInfo winningInfo;

    private static Stream<Arguments> provideLottoTestCases() {
        return Stream.of(
                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIRST),

                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 7)), Rank.SECOND),

                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 16)), Rank.THIRD),

                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 3, 4, 15, 16)), Rank.FOURTH),
                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 3, 4, 15, 7)), Rank.FOURTH),

                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 3, 14, 15, 16)), Rank.FIFTH),
                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 3, 14, 15, 7)), Rank.FIFTH),

                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 13, 14, 15, 16)), Rank.NOTHING),
                Arguments.of(createCustomLotto(Arrays.asList(1, 2, 13, 14, 15, 7)), Rank.NOTHING),
                Arguments.of(createCustomLotto(Arrays.asList(1, 12, 13, 14, 15, 16)), Rank.NOTHING),
                Arguments.of(createCustomLotto(Arrays.asList(1, 12, 13, 14, 15, 7)), Rank.NOTHING),
                Arguments.of(createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16)), Rank.NOTHING),
                Arguments.of(createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 7)), Rank.NOTHING)
        );
    }

    @BeforeEach
    void setUp() {
        lottoMatcher = new LottoMatcher();
        // 추첨 로또 번호: 1, 2, 3, 4, 5, 6
        Numbers winningLottoNumbers = Numbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        // 보너스 번호: 7
        Number bonusNumber = NumberFactory.createBonusNumber(7, winningLottoNumbers);

        winningInfo = WinningInfo.of(winningLottoNumbers, bonusNumber);
    }

    @DisplayName("발행한 로또의 등수를 확인한다.")
    @MethodSource("provideLottoTestCases")
    @ParameterizedTest(name = "입력값: \"{0}\", 맞춘 결과: \"{1}\"")
    void 발행한_로또의_등수를_확인한다(Lotto buyerLotto, Rank rank) {
        Assertions.assertThat(lottoMatcher.calculateRank(buyerLotto, winningInfo))
                .isEqualTo(rank);
    }
}
