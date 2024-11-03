package lotto.store.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWinningNumbers extends WinningNumbers {

    public static final List<Integer> testLottoInts = List.of(1, 2, 3, 4, 5, 6);
    public static final int testBonusInt = 7;
    private static final Lotto testLotto = LottoGenerator.manual(testLottoInts);
    private static final LottoNumber testBonus = new LottoNumber(testBonusInt);

    public static final Lotto FIRST_LOTTO = LottoGenerator.manual(List.of(1, 2, 3, 4, 5, 6));
    public static final Lotto SECOND_LOTTO = LottoGenerator.manual(List.of(1, 2, 3, 4, 5, 7));
    public static final Lotto THIRD_LOTTO = LottoGenerator.manual(List.of(1, 2, 3, 4, 5, 45));
    public static final Lotto FOURTH_LOTTO = LottoGenerator.manual(List.of(1, 2, 3, 4, 44, 45));
    public static final Lotto FIFTH_LOTTO = LottoGenerator.manual(List.of(1, 2, 3, 43, 44, 45));
    public static final Lotto FAIL_LOTTO = LottoGenerator.manual(List.of(1, 2, 42, 43, 44, 45));

    TestWinningNumbers() {
        super(testLotto, testBonus);
    }

    public static WinningNumbers create() {
        return new TestWinningNumbers();
    }

    @DisplayName("테스트용 로또는 정확히 이름과 같은 랭크를 반환한다.")
    @ParameterizedTest
    @MethodSource("testLottoOptions")
    void test1(Lotto lotto, LottoRank expected) {
        assertEquals(TestWinningNumbers.create().rank(lotto), expected);
    }

    static Stream<Arguments> testLottoOptions() {
        return Stream.of(
                Arguments.arguments(FIRST_LOTTO, LottoRank.FIRST),
                Arguments.arguments(SECOND_LOTTO, LottoRank.SECOND),
                Arguments.arguments(THIRD_LOTTO, LottoRank.THIRD),
                Arguments.arguments(FOURTH_LOTTO, LottoRank.FOURTH),
                Arguments.arguments(FIFTH_LOTTO, LottoRank.FIFTH),
                Arguments.arguments(FAIL_LOTTO, LottoRank.FAIL)
        );
    }
}
