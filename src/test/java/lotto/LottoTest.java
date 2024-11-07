package lotto;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.model.domain.Lotto;
import lotto.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LottoTest {

    static Stream<List<Integer>> lottoNumberRangeTest() {
        return Stream.of(Arrays.asList(0, 1, 2, 3, 4, 5), // 0 포함
                Arrays.asList(-1, 1, 2, 3, 4, 5), // 음수 포함
                Arrays.asList(1, 2, 3, 4, 5, 50), // 50 포함
                Arrays.asList(1, 2, 3, 4, 5, 46)  // 46 포함
        );
    }

    @Test
    void 로또_번호와_보너스_번호_중복() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 5;
        assertThrows(IllegalArgumentException.class, () -> Validator.validateDuplicateNumber(numbers, bonus));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThrows(IllegalArgumentException.class, () -> Validator.validateDuplicateNumber(numbers));
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개를 초과하면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumberCount(numbers));
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수_미만() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumberCount(numbers));
    }

    @DisplayName("로또 번호에 정수 이외의 값은 올 수 없다.")
    @Test
    void 로또_번호의_입력_검증() {
        String numbers = "1,2,a,4,5";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCommaSeparated(numbers));

    }

    @DisplayName("입력 값은 쉼표로 구분되어야 한다.")
    @Test
    void 쉼표로_구분되지않은_입력_검증() {
        String numbers = "1 2 3 4 5 6";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCommaSeparated(numbers));
    }

    @DisplayName("빈 문자열은 올 수 없다.")
    @Test
    void 빈_문자열_검증() {
        String numbers = "";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCommaSeparated(numbers));
    }

    @DisplayName("로또 숫자의 범위가 잘못된 경우 예외 처리한다.")
    @ParameterizedTest
    @MethodSource("lottoNumberRangeTest")
    void 로또_번호의_범위_테스트(List<Integer> testNumber) {
        assertThatThrownBy(() -> {
            for (Integer number : testNumber) {
                Validator.validateRange(number);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 정수가 아니라면 예외 처리한다.")
    void 보너스_번호_정수_외의값() {
        String bonus = "a";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateBonusNumber(bonus));
    }

    @Test
    @DisplayName("구입 금액의 정상 입력")
    void 구입금액_정상입력() {
        int validMoney = 1000;
        assertDoesNotThrow(() -> Validator.validateMoneyUnit(validMoney));
    }

    @Test
    @DisplayName("구입 금액의 음수 입력")
    void 구입금액_음수입력() {
        int invalidMoney = -1000;
        assertThrows(IllegalArgumentException.class, () -> Validator.validateMoneyUnit(invalidMoney));
    }

    @Test
    @DisplayName("구입 금액의 1,000원의 배수가 아닌 입력")
    void 구입금액_1000원_배수입력() {
        int invalidMoney = 1500;
        assertThrows(IllegalArgumentException.class, () -> Validator.validateMoneyUnit(invalidMoney));
    }

    @Test
    @DisplayName("구입 금액의 0원 입력")
    void 구입금액_0원입력() {
        int invalidMoney = 0;
        assertThrows(IllegalArgumentException.class, () -> Validator.validateMoneyUnit(invalidMoney));
    }
}
