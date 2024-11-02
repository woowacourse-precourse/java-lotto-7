package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AdditionalApplicationTest {
    private final Lotto defaultWinningNumbers = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    private final int defaultBonusNumber = 7;


//    @ParameterizedTest
//    @ValueSource(ints = {0, 1, 2, 3, 4})
    // 현재 수정된 기능으로 임시 보류
//    void 숫자를_뽑을_때_오름차순으로_정렬한다(int lottoNumbersIndex) {
//        List<Integer> testNumbers = Application.pickAscendingNumbers();
//
//        assertThat(testNumbers.get(lottoNumbersIndex)).isLessThan(testNumbers.get(lottoNumbersIndex + 1));
//    }


//
//    @ParameterizedTest
//    @MethodSource("lottoWithMatchingNumberProvider")
//    void 당첨번호와_로또의_일치개수를_확인한다(int expectedMatchingAmount, List<Integer> numbers) {
//        Lotto lotto = new Lotto(numbers);
//
//        assertThat(defaultWinningNumbers.drawEachLotto(lotto)).isEqualTo(expectedMatchingAmount);
//    }
//
//    static Stream<Object[]> lottoWithMatchingNumberProvider() {
//        return Stream.of(
//                new Object[]{6, Arrays.asList(1, 2, 3, 4, 5, 6)}, //6개 일치
//                new Object[]{5, Arrays.asList(1, 2, 3, 4, 5, 7)}, //5개 일치
//                new Object[]{5, Arrays.asList(1, 2, 3, 4, 5, 8)}, //5개 일치
//                new Object[]{4, Arrays.asList(1, 2, 3, 4, 8, 9)}, //4개 일치
//                new Object[]{3, Arrays.asList(1, 2, 3, 8, 9, 10)}, //3개 일치
//                new Object[]{2, Arrays.asList(1, 2, 8, 9, 10, 11)}, //2개 일치
//                new Object[]{1, Arrays.asList(1, 8, 9, 10, 11, 12)}, //1개 일치
//                new Object[]{0, Arrays.asList(8, 9, 10, 11, 12, 13)} //0개 일치
//        );
//    }
//
//    @Test
//    void 보너스번호가_일치하면_true를_반환한다() {
//        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
//
//        assertThat(Application.drawBonusNumber(lotto, defaultBonusNumber)).isTrue();
//    }
//
//    @Test
//    void 보너스번호가_불일치하면_false를_반환한다() {
//        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
//
//        assertThat(Application.drawBonusNumber(lotto, defaultBonusNumber)).isFalse();
//    }
//
//    @ParameterizedTest
//    @MethodSource("lottoWithWinningRankProvider")
//    void 로또의_당첨_등수를_확인한다(WinningRank expectedWinningRank, int matchingAmount, List<Integer> numbers) {
//        Lotto lotto = new Lotto(numbers);
//        boolean matchesBonusNumber = numbers.contains(defaultBonusNumber);
//
//        assertThat(WinningRank.findWinningStatusByMatchingAmount(matchingAmount, matchesBonusNumber))
//                .isEqualTo(expectedWinningRank);
//    }
//
//    static Stream<Object[]> lottoWithWinningRankProvider() {
//        return Stream.of(
//                new Object[]{WinningRank.FIRST, 6, Arrays.asList(1, 2, 3, 4, 5, 6)}, //6개 일치
//                new Object[]{WinningRank.SECOND, 5, Arrays.asList(1, 2, 3, 4, 5, 7)}, //5개 일치
//                new Object[]{WinningRank.THIRD, 5, Arrays.asList(1, 2, 3, 4, 5, 8)}, //5개 일치
//                new Object[]{WinningRank.FOURTH, 4, Arrays.asList(1, 2, 3, 4, 8, 9)}, //4개 일치
//                new Object[]{WinningRank.FIFTH, 3, Arrays.asList(1, 2, 3, 8, 9, 10)}, //3개 일치
//                new Object[]{WinningRank.FAIL, 2, Arrays.asList(1, 2, 8, 9, 10, 11)}, //2개 일치
//                new Object[]{WinningRank.FAIL, 1, Arrays.asList(1, 8, 9, 10, 11, 12)}, //1개 일치
//                new Object[]{WinningRank.FAIL, 0, Arrays.asList(8, 9, 10, 11, 12, 13)} //0개 일치
//        );
//    }
//
//    @Test
//    void 등수별_당첨된_로또_개수를_구한다() {
//        List<Lotto> lottos = new ArrayList<>(Arrays.asList(
//                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
//                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))),
//                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8))),
//                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9))),
//                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 8, 9, 10))),
//                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 8, 9, 10, 11))),
//                new Lotto(new ArrayList<>(Arrays.asList(1, 8, 9, 10, 11, 12))),
//                new Lotto(new ArrayList<>(Arrays.asList(8, 9, 10, 11, 12, 13)))
//        ));
//
//        Map<WinningRank, Integer> winningResult = Application.drawLottos(lottos, defaultWinningNumbers,
//                defaultBonusNumber);
//
//        assertThat(winningResult.get(WinningRank.FIRST)).isEqualTo(1);
//        assertThat(winningResult.get(WinningRank.SECOND)).isEqualTo(1);
//        assertThat(winningResult.get(WinningRank.THIRD)).isEqualTo(1);
//        assertThat(winningResult.get(WinningRank.FOURTH)).isEqualTo(1);
//        assertThat(winningResult.get(WinningRank.FIFTH)).isEqualTo(1);
//        assertThat(winningResult.get(WinningRank.FAIL)).isEqualTo(3);
//    }
//
//    @Test
//    void 수익률을_구한다() {
//        int earnings = 5000;
//        int expense = 8000;
//
//        double earningsRate = Application.calculateEarningsRate(earnings, expense);
//
//        assertThat(earningsRate).isEqualTo(62.5);
//    }


}
