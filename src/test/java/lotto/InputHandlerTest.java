package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.input.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputHandlerTest {

    @DisplayName("로또 구입 금액의 단위는 천 원이다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "5000", "10000"})
    void purchaseUnit_shouldBe_1000Won(String input) {
        int purchaseAmount = InputHandler.toInt(input);

        assertThat(purchaseAmount % 1000).isZero();
    }

    @DisplayName("로또 구입 금액이 정수형 최댓값을 초과하는 경우 예외처리")
    @Test
    void throwException_when_purchaseAmountExceedsMaxInt() {
        assertThatThrownBy(() -> InputHandler.toInt("22000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 구분자가 쉼표가 아닌 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:3:4:5:6", "1-2-3-4-5-6", "1 2 3 4 5 6"})
    void throwException_when_delimiterIsNotComma() {
        assertThatThrownBy(() -> InputHandler.toNumbers("1:2:3:4:5:6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
