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

    @Test
    void 양의정수_10자리_이하_금액을_입력한다() {
        String testString = "50";

        assertThatCode(() -> Application.validateInputInteger(testString))
                .doesNotThrowAnyException();
    }

    @Test
    void 금액_null일시_예외() {
        String testNumber = null;

        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.validateInputValue(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 금액_빈_문자열일시_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.validateInputValue(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20.2, -1.0, 0.5, 2.0, 2.5, 3.24321"})
    void 금액이_정수가_아니면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20, -1, 0"})
    void 금액이_양수가_아니면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000", "123456789123456789"})
    void 금액이_10자리를_넘어가면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 10자리 이하의 금액을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5", "11000:11", "25000:25", "303000:303", "1474134000:1474134",
            "1000000000:1000000"}, delimiter = ':')
    void 금액을_1000으로_나누어_개수를_구한다(String testNumber, int expected) {
        int lottoAmount = Application.countLottoAmount(testNumber);

        assertThat(lottoAmount).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "1002", "2524", "100001", "100020"})
    void 금액이_1000으로_나누어떨어지지_않으면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.countLottoAmount(testNumber))
                .withMessage("[ERROR] 1000 단위의 금액을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 숫자를_뽑을_때_오름차순으로_정렬한다(int lottoNumbersIndex) {
        List<Integer> testNumbers = Application.pickAscendingNumbers();

        assertThat(testNumbers.get(lottoNumbersIndex)).isLessThan(testNumbers.get(lottoNumbersIndex + 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void 랜덤넘버_6개를_뽑아_로또를_한장_발행한다(int lottoNumbersIndex) {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = Application.issueOneLotto(randomNumbers);

        assertThat(lotto.getNumbers()).contains(randomNumbers.get(lottoNumbersIndex));
    }

    @Test
    void 구매_개수만큼_로또를_발행한다() {
        int testNumber = 2;

        List<Lotto> lottos = Application.issueLottos(testNumber);

        assertThat(lottos.size()).isEqualTo(testNumber);
    }

    @Test
    void 당첨번호_null일시_예외() {
        String testNumber = null;

        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputValue(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 당첨번호_빈_문자열일시_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.validateInputValue(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3", "3:4", "4:5", "5:6"}, delimiter = ':')
    void 당첨번호를_split해_순서대로_저장한다_1(int lottoNumbersIndex, int lottoNumber) {
        String testNumber = "1,2,3,4,5,6";
        Lotto lotto = Application.registerWinningNumbers(testNumber);

        assertThat(lotto.getNumbers().get(lottoNumbersIndex)).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 5", "55$5", "$5 5", "5$5 ", "5 $ 5"})
    void 하나의_번호_중간에_다른_문자가_있으면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.registerWinningNumbers(testNumber))
                .withMessage("[ERROR] 숫자값만 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" 45", "45 ", "    45", "45   "})
    void 번호와_번호_사이_띄어쓰기는_허용(String testNumber) {
        String defaultNumbers = "1,2,3,4,5,";
        assertThatCode(() -> Application.registerWinningNumbers(defaultNumbers + testNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("invalidLottoNumbersAmountProvider")
    void 당첨번호가_6개가_아니면_예외(List<Integer> testNumbers) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new Lotto(testNumbers))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    static Stream<List<Integer>> invalidLottoNumbersAmountProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 당첨번호가_1이상_45이하가_아니면_예외(int testNumber) {
        List<Integer> numbersIncludingInvalidRange = new ArrayList<>(Arrays.asList(testNumber, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new Lotto(numbersIncludingInvalidRange))
                .withMessage("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
    }

    @Test
    void 당첨번호가_중복되면_예외() {
        List<Integer> numbersIncludingDuplication = new ArrayList<>(Arrays.asList(5, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new Lotto(numbersIncludingDuplication))
                .withMessage("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
    }

    @Test
    void 보너스번호_null일시_예외() {
        String testNumber = null;

        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputValue(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 보너스번호_빈_문자열일시_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.validateInputValue(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @Test
    void 보너스번호를_저장한다() {
        Lotto defaultWinningNumbers = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        String testNumber = "7";

        assertThatCode(() -> Application.registerBonusNumber(testNumber, defaultWinningNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void 보너스번호_1이상_45이하가_아니면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Application.registerBonusNumber(testNumber, defaultWinningNumbers))
                .withMessage("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
    }

    @Test
    void 보너스번호_당첨번호와_중복되면_예외() {
        int testNumber = 1;
        assertThatIllegalArgumentException().isThrownBy(
                        () -> defaultWinningNumbers.validateDuplicationWithBonusNumber(testNumber))
                .withMessage("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 값입니다.");
    }

    @ParameterizedTest
    @MethodSource("lottoWithMatchingNumberProvider")
    void 당첨번호와_로또의_일치개수를_확인한다(int expectedMatchingAmount, List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);

        assertThat(defaultWinningNumbers.drawEachLotto(lotto)).isEqualTo(expectedMatchingAmount);
    }

    static Stream<Object[]> lottoWithMatchingNumberProvider() {
        return Stream.of(
                new Object[]{6, Arrays.asList(1, 2, 3, 4, 5, 6)}, //6개 일치
                new Object[]{5, Arrays.asList(1, 2, 3, 4, 5, 7)}, //5개 일치
                new Object[]{5, Arrays.asList(1, 2, 3, 4, 5, 8)}, //5개 일치
                new Object[]{4, Arrays.asList(1, 2, 3, 4, 8, 9)}, //4개 일치
                new Object[]{3, Arrays.asList(1, 2, 3, 8, 9, 10)}, //3개 일치
                new Object[]{2, Arrays.asList(1, 2, 8, 9, 10, 11)}, //2개 일치
                new Object[]{1, Arrays.asList(1, 8, 9, 10, 11, 12)}, //1개 일치
                new Object[]{0, Arrays.asList(8, 9, 10, 11, 12, 13)} //0개 일치
        );
    }

    @Test
    void 보너스번호가_일치하면_true를_반환한다() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));

        assertThat(Application.drawBonusNumber(lotto, defaultBonusNumber)).isTrue();
    }

    @Test
    void 보너스번호가_불일치하면_false를_반환한다() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(Application.drawBonusNumber(lotto, defaultBonusNumber)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("lottoWithWinningRankProvider")
    void 로또의_당첨_등수를_확인한다(WinningRank expectedWinningRank, int matchingAmount, List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        boolean matchesBonusNumber = numbers.contains(defaultBonusNumber);

        assertThat(WinningRank.findWinningStatusByMatchingAmount(matchingAmount, matchesBonusNumber))
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

    @Test
    void 등수별_당첨된_로또_개수를_구한다() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(
                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))),
                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8))),
                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9))),
                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 8, 9, 10))),
                new Lotto(new ArrayList<>(Arrays.asList(1, 2, 8, 9, 10, 11))),
                new Lotto(new ArrayList<>(Arrays.asList(1, 8, 9, 10, 11, 12))),
                new Lotto(new ArrayList<>(Arrays.asList(8, 9, 10, 11, 12, 13)))
        ));

        Map<WinningRank, Integer> winningResult = Application.drawLottos(lottos, defaultWinningNumbers,
                defaultBonusNumber);

        assertThat(winningResult.get(WinningRank.FIRST)).isEqualTo(1);
        assertThat(winningResult.get(WinningRank.SECOND)).isEqualTo(1);
        assertThat(winningResult.get(WinningRank.THIRD)).isEqualTo(1);
        assertThat(winningResult.get(WinningRank.FOURTH)).isEqualTo(1);
        assertThat(winningResult.get(WinningRank.FIFTH)).isEqualTo(1);
        assertThat(winningResult.get(WinningRank.FAIL)).isEqualTo(3);
    }

    @Test
    void 수익률을_구한다() {
        int earnings = 5000;
        int expense = 8000;

        double earningsRate = Application.calculateEarningsRate(earnings, expense);

        assertThat(earningsRate).isEqualTo(62.5);
    }


}
