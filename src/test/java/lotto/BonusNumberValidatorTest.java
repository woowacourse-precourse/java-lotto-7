package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {

    @DisplayName("null 입력 시 예외 발생")
    @Test
    void null_입력_예외_검증() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> BonusNumberValidator.validate(null, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력이 null입니다.");
    }

    @DisplayName("빈 문자열 입력 시 예외 발생")
    @Test
    void 빈_문자열_입력_예외_검증() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> BonusNumberValidator.validate("", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호를 입력해주세요.");
    }

    @DisplayName("숫자가 아닌 입력 시 예외 발생")
    @Test
    void 숫자_아닌_입력_예외_검증() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> BonusNumberValidator.validate("abc", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1에서 45 사이의 정수여야함.");
    }

    @DisplayName("1~45 범위를 벗어난 숫자 입력 시 예외 발생")
    @Test
    void 범위_벗어난_숫자_입력_예외_검증() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> BonusNumberValidator.validate("0", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1에서 45 사이의 정수여야함.");

        assertThatThrownBy(() -> BonusNumberValidator.validate("46", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1에서 45 사이의 정수여야함.");
    }

    @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외 발생")
    @Test
    void 중복된_번호_입력_예외_검증() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> BonusNumberValidator.validate("3", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("올바른 보너스 번호 입력 시 예외 없음")
    @Test
    void 올바른_보너스_번호_검증() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumberValidator.validate("7", winningNumbers); // 예외가 발생하지 않으면 성공
    }
}
