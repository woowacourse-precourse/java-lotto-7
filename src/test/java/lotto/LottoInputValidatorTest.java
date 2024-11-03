package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputValidatorTest {
    @DisplayName("1미만 || 45초과 숫자가 입력되면 예외 발생")
    @Test
    void 입력_유효성_테스트_1() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 60);
        assertThatThrownBy(() -> InputValidator.validLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 미만 || 1000원 단위 아닌")
    @Test
    void 입력_유효성_테스트_2() {
        assertThatThrownBy(() -> InputValidator.validatePrice(900))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.validatePrice(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
