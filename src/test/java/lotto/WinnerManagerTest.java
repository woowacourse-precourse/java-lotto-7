package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import constant.Rank;
import input.BonusNumberInputProcessor;
import input.LottoWinnerNumberInputProcessor;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import validation.BonusNumberValidator;

public class WinnerManagerTest {

    private WinnerManager winnerManager;

    @BeforeEach
    void 테스트_사전_작업() {
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        BonusNumberInputProcessor bonusNumberInputProcessor = new BonusNumberInputProcessor(bonusNumberValidator);
        LottoWinnerNumberInputProcessor lottoWinnerNumberInputProcessor = new LottoWinnerNumberInputProcessor();
        this.winnerManager = new WinnerManager(lottoWinnerNumberInputProcessor, bonusNumberInputProcessor);
    }

    @DisplayName("랭크를 제대로 매기는지 테스트")
    @ParameterizedTest
    @MethodSource("랭크_테스트_케이스")
    void 랭크를_제대로_매기는지_테스트(Integer matchCount, boolean bonusMatch, Rank expectedRank) {
        assertEquals(expectedRank, winnerManager.rankingDecision(matchCount, bonusMatch));
    }

    private static Stream<Arguments> 랭크_테스트_케이스() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST_RANK),
                Arguments.of(6, true, Rank.FIRST_RANK),
                Arguments.of(5, true, Rank.SECOND_RANK),
                Arguments.of(5, false, Rank.THIRD_RANK),
                Arguments.of(4, true, Rank.FORTH_RANK),
                Arguments.of(4, false, Rank.FORTH_RANK),
                Arguments.of(3, true, Rank.FIFTH_RANK),
                Arguments.of(3, false, Rank.FIFTH_RANK),
                Arguments.of(0, false, Rank.UN_RANK)
        );
    }
}
