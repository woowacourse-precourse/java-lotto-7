package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputHandlerTest {

    @DisplayName("로또 구입 금액의 단위는 천 원이다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "5000", "10000"})
    void lottoUnitBudgetShouldBe1000Won(String input) {
        int budget = InputHandler.toInt(input);

        assertThat(budget % 1000).isZero();
    }
}
