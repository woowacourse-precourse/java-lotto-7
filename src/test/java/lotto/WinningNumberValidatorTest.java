package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberValidatorTest {

    @DisplayName("정상적인 입력을 통한 당첨 번호 검증")
    @Test
    void 정상적인_입력_검증() {
        List<Integer> numbers = WinningNumbersValidator.validate("1,2,3,4,5,6");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("공백이 포함된 입력 처리")
    @Test
    void 공백이_포함된_입력_검증() {
        List<Integer> numbers = WinningNumbersValidator.validate(" 1 , 2 , 3 , 4 , 5 , 6 ");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("쉼표가 연속으로 사용된 경우 예외 발생")
    @Test
    void 쉼표가_연속으로_사용된_경우_예외_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 쉼표 사용이 아닙니다.");
    }

    @DisplayName("입력이 쉼표로 시작하는 경우 예외 발생")
    @Test
    void 쉼표로_시작하는_경우_예외_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 쉼표 사용이 아닙니다.");
    }

    @DisplayName("입력이 쉼표로 끝나는 경우 예외 발생")
    @Test
    void 쉼표로_끝나는_경우_예외_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 쉼표 사용이 아닙니다.");
    }

    @DisplayName("숫자 개수가 적은 경우 예외 발생")
    @Test
    void 숫자_개수가_적을때_오류_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("숫자 개수가 많은 경우 예외 발생")
    @Test
    void 숫자_개수가_많을때_오류_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("숫자 범위가 올바르지 않은 경우 예외 발생")
    @Test
    void 숫자_범위_오류_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45 사이의 정수여야합니다.");

        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45 사이의 정수여야합니다.");
    }

    @DisplayName("중복된 숫자가 포함된 경우 예외 발생")
    @Test
    void 중복된_숫자_오류_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,2,3,3,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
    }

    @DisplayName("숫자가 아닌 문자 입력 시 예외 발생")
    @Test
    void 문자_입력_예외_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("a,b,c,d,e,f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1에서 45 사이의 정수만 입력 가능합니다.");
    }

    @DisplayName("빈 문자열 입력 시 예외 발생")
    @Test
    void 빈_문자열_입력_예외_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력이 비어있습니다.");
    }

    @DisplayName("null 입력 시 예외 발생")
    @Test
    void null_입력_예외_검증() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력이 null입니다.");
    }
}
