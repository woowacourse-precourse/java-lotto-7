package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import lotto.validator.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.model.constants.NumberValidatorConstans.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest extends NsTest {

    private static Stream<String> invalidNumberProvider() {
        return Stream.of(
                " ",
                "\n",
                "\t",
                "",
                "abc",
                "100a"
        );
    }


    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_출력_확인() {
        assertSimpleTest(() -> {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(numbers);
            String result = lotto.toString();
            assertThat(result).isEqualTo(numbers.toString());
        });
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            String bonusNumber = "2";
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            NumberValidator.checkValidBonusNumber(bonusNumber, winningNumbers);
            assertThat(output()).contains(BONUS_NUMBER_NOT_WINNING_NUMBER.getMessage());
        });
    }

    @Test
    void 로또_번호가_1부터_45_사이가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            String inputNumbers="0,1,2,3,4,5";
            NumberValidator.checkValidWinningNumbers(inputNumbers);
            assertThat(output()).contains(NUMBER_NOT_IN_RANGE.getMessage());
        });
    }

    @ParameterizedTest
    @MethodSource("invalidNumberProvider")
    void 로또_번호가_숫자가_아니면_예외가_발생한다(String inputNumber) {
        assertSimpleTest(() -> {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            NumberValidator.checkValidBonusNumber(inputNumber, winningNumbers);
            assertThat(output()).contains(NUMBER_NOT_NUMERIC_MESSAGE.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
