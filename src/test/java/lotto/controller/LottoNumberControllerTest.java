package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;

public class LottoNumberControllerTest {

    private final LottoNumberController lottoNumberController = new LottoNumberController();

    @Test
    @DisplayName("올바른 형식의 당첨 번호가 입력된 경우 Lotto 객체가 생성된다.")
    void should_CreateLottoInstance_When_InputIsValid() {
        String input = "1,2,3,4,5,6";
        Lotto lotto = lottoNumberController.generateWinningLotto(input);

        assertThat(lotto).isNotNull();
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("6개 미만의 숫자가 입력되면 예외가 발생한다.")
    void should_ThrowException_When_LessThanSixNumbersProvided() {
        String input = "1,2,3,4,5";

        assertThatThrownBy(() -> lottoNumberController.generateWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("숫자가 1~45 범위를 벗어나면 예외가 발생한다.")
    void should_ThrowException_When_NumberIsOutOfRange() {
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> lottoNumberController.generateWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 입력되면 예외가 발생한다.")
    void should_ThrowException_When_DuplicateNumbersProvided() {
        String input = "1,2,3,4,5,5";

        assertThatThrownBy(() -> lottoNumberController.generateWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생한다.")
    void should_ThrowException_When_InputContainsNonNumericValues() {
        String input = "1,2,a,4,5,6";

        assertThatThrownBy(() -> lottoNumberController.generateWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
    }
}
