package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputDomainTest {
    @DisplayName("당첨 번호가 유효한 경우 테스트에 성공한다.")
    @Test
    void 당첨_번호가_유효한_경우_테스트에_성공한다() {
        String input = "1,2,3,4,5,6";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = InputDomain.convertWinningNumber(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("당첨 번호가 6개 미만인 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개_미만인_경우_예외가_발생한다() {
        String input = "1,2,3,4,5";

        assertThatThrownBy(() -> InputDomain.convertWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 초과인 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개_초과인_경우_예외가_발생한다() {
        String input = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> InputDomain.convertWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있는 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복이_있는_경우_예외가_발생한다() {
        String input = "1,2,3,4,5,5";

        assertThatThrownBy(() -> InputDomain.convertWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 미만인 당첨 번호가 있는 경우 예외가 발생한다.")
    @Test
    void 범위보다_작은_당첨_번호가_있는_경우_예외가_발생한다() {
        String input = "0,2,3,4,5,6";

        assertThatThrownBy(() -> InputDomain.convertWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45 초과인 당첨 번호가 있는 경우 예외가 발생한다.")
    @Test
    void 범위보다_큰_당첨_번호가_있는_경우_예외가_발생한다() {
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> InputDomain.convertWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 당첨 번호가 있는 경우 예외가 발생한다.")
    @Test
    void 숫자가_아닌_당첨_번호가_있는_경우_예외가_발생한다() {
        String input = "1,2,3,4,5,삼";

        assertThatThrownBy(() -> InputDomain.convertWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 유효하다면 테스트에 성공한다.")
    @Test
    void 보너스_번호가_유효하다면_테스트에_성공한다() {
        String input = "7";

        int result = InputDomain.convertBonusNumber(input);

        assertThat(result).isEqualTo(7);
    }

    @DisplayName("1 미만인 보너스 번호가 있는 경우 예외가 발생한다.")
    @Test
    void 범위보다_작은_보너스_번호가_있는_경우_예외가_발생한다() {
        String input = "0";

        assertThatThrownBy(() -> InputDomain.convertBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45 초과인 보너스 번호가 있는 경우 예외가 발생한다.")
    @Test
    void 범위보다_큰_보너스_번호가_있는_경우_예외가_발생한다() {
        String input = "46";

        assertThatThrownBy(() -> InputDomain.convertBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 보너스 번호가 있는 경우 예외가 발생한다.")
    @Test
    void 숫자가_아닌_보너스_번호가_있는_경우_예외가_발생한다() {
        String input = "이십칠";

        assertThatThrownBy(() -> InputDomain.convertBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
