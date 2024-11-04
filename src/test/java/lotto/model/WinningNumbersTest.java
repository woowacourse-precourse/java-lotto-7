package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersTest {
    private static final List<Integer> MAIN_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;
    private static final List<Integer> EXCLUSIVE_WITH_MAIN_NUMBERS = List.of(10,11,12,13,14,15);

    @ParameterizedTest
    @MethodSource("providePrizeTestArguments")
    @DisplayName("전달한 로또와 당첨 번호를 비교해 당첨 등수를 반환한다.")
    void testReturnPrizeForGivenLotto(List<Integer> lottoNumbers, Prize expectedPrize) {
        Lotto mainNumbers = new Lotto(MAIN_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER);
        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);
        Lotto lotto = new Lotto(lottoNumbers);

        Prize prize = winningNumbers.checkPrize(lotto);
        assertThat(prize).isEqualTo(expectedPrize);
    }

    private static Stream<Arguments> providePrizeTestArguments() {
        return Stream.of(
                Arguments.of(createLottoNumbers(1, 5), Prize.NON),
                Arguments.of(createLottoNumbersWithBonusNumber(1, 4), Prize.NON),
                Arguments.of(createLottoNumbers(2, 4), Prize.NON),
                Arguments.of(createLottoNumbersWithBonusNumber(2, 3), Prize.NON),
                Arguments.of(createLottoNumbers(3, 3), Prize.FIFTH),
                Arguments.of(createLottoNumbersWithBonusNumber(3, 2), Prize.FIFTH),
                Arguments.of(createLottoNumbers(4, 2), Prize.FOURTH),
                Arguments.of(createLottoNumbersWithBonusNumber(4, 1), Prize.FOURTH),
                Arguments.of(createLottoNumbers(5, 1), Prize.THIRD),
                Arguments.of(createLottoNumbersWithBonusNumber(5, 0), Prize.SECOND),
                Arguments.of(new ArrayList<>(MAIN_NUMBERS), Prize.FIRST)
        );
    }

    private static List<Integer> createLottoNumbers(int mainCount, int exclusiveMainCount) {
        List<Integer> numbers = new ArrayList<>(MAIN_NUMBERS.subList(0, mainCount));
        numbers.addAll(EXCLUSIVE_WITH_MAIN_NUMBERS.subList(0, exclusiveMainCount));
        return numbers;
    }

    private static List<Integer> createLottoNumbersWithBonusNumber(int mainCount, int exclusiveMainCount) {
        List<Integer> numbers = createLottoNumbers(mainCount, exclusiveMainCount);
        numbers.add(BONUS_NUMBER);
        return numbers;
    }
}
