package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationInputTest {

    @Test
    @DisplayName("당첨 번호 입력이 숫자 리스트로 변환된다.")
    void winningNumbers_입력_테스트() {
        String input = "1, 2, 3,4,5, 6";

        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(token -> Integer.parseInt(token.trim()))
                .toList();

        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값을 포함하면 예외가 발생한다.")
    void winningNumbers_입력_예외_테스트() {
        String input = "1, 2, 3, 4, five, 6";

        assertThatThrownBy(() -> {
            List<Integer> winningNumbers = Arrays.stream(input.split(","))
                    .map(token -> {
                        try {
                            return Integer.parseInt(token.trim());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("[ERROR] 쉼표로 구분된 숫자만 입력해야 합니다.");
                        }
                    })
                    .toList();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표로 구분된 숫자만 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호 입력이 숫자로 변환된다.")
    void bonusNumber_입력_테스트() {
        String input = "7";

        int bonusNumber = Integer.parseInt(input);

        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    void bonusNumber_입력_예외_테스트() {
        String input = "seven";

        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class);
    }
}