package lotto.View;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.View.Input.Input;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @Test
    void 올바른_로또_구입_금액_입력() {
        Input input = new Input();
        int actual = input.MoneyValuation(5000);
        Assertions.assertThat(actual).isEqualTo(5000);
    }
}
