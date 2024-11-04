package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.util.NumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("providePrizeTestArguments")
    @DisplayName("전달한 로또와 당첨 번호를 비교해 당첨 등수를 반환한다.")
    void testReturnPrizeForGivenLotto(List<Integer> lottoNumbers, Prize expectedPrize) {
        Lotto mainNumbers = new Lotto(NumbersGenerator.MAIN_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(NumbersGenerator.BONUS_NUMBER);
        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);
        Lotto lotto = new Lotto(lottoNumbers);

        Prize prize = winningNumbers.checkPrize(lotto);
        assertThat(prize).isEqualTo(expectedPrize);
    }

    private static Stream<Arguments> providePrizeTestArguments() {
        return Stream.of(
                Arguments.of(NumbersGenerator.createLottoNumbers(1, 5), Prize.NON),
                Arguments.of(NumbersGenerator.createLottoNumbersWithBonusNumber(1, 4), Prize.NON),
                Arguments.of(NumbersGenerator.createLottoNumbers(2, 4), Prize.NON),
                Arguments.of(NumbersGenerator.createLottoNumbersWithBonusNumber(2, 3), Prize.NON),
                Arguments.of(NumbersGenerator.createLottoNumbers(3, 3), Prize.FIFTH),
                Arguments.of(NumbersGenerator.createLottoNumbersWithBonusNumber(3, 2), Prize.FIFTH),
                Arguments.of(NumbersGenerator.createLottoNumbers(4, 2), Prize.FOURTH),
                Arguments.of(NumbersGenerator.createLottoNumbersWithBonusNumber(4, 1), Prize.FOURTH),
                Arguments.of(NumbersGenerator.createLottoNumbers(5, 1), Prize.THIRD),
                Arguments.of(NumbersGenerator.createLottoNumbersWithBonusNumber(5, 0), Prize.SECOND),
                Arguments.of(new ArrayList<>(NumbersGenerator.MAIN_NUMBERS), Prize.FIRST)
        );
    }
}
