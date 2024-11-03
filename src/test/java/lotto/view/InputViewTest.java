package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("유효한 금액을 입력받을 수 있다")
    void lottoMoneyInput_validInput() {
        // given
        InputView inputView = new InputView(() -> "1000");

        // when
        int result = inputView.lottoMoneyInput();

        // then
        assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("유효하지 않은 금액 입력 시 예외가 발생한다")
    void lottoMoneyInput_invalidInput() {
        // given
        InputView inputView = new InputView(() -> "abc");

        // when & then
        assertThatThrownBy(inputView::lottoMoneyInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력하신 금액이 양의 정수가 아닙니다.");
    }

    @Test
    @DisplayName("유효한 로또 번호를 입력받을 수 있다")
    void lottoNumberInput_validInput() {
        // given
        InputView inputView = new InputView(() -> "1,2,3,4,5,6");

        // when
        String[] result = inputView.lottoNumberInput();

        // then
        assertThat(result).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("유효하지 않은 로또 번호 형식 시 예외가 발생한다")
    void lottoNumberInput_invalidInput() {
        // given
        InputView inputView = new InputView(() -> "1,2,3,abc,5,6");

        // when & then
        assertThatThrownBy(inputView::lottoNumberInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바르지 않은 번호 형식입니다.");
    }
}
