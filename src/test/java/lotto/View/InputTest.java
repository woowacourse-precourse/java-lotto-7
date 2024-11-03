package lotto.View;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.View.Input.Input;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import java.util.Arrays;

public class InputTest {

    @Test
    void 올바른_로또_구입_금액_입력() {
        Input input = new Input();
        int actual = input.MoneyValidation(5000);
        Assertions.assertThat(actual).isEqualTo(5000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 2500, 3333, 999})
    void 잘못된_로또_구입_금액_입력(int invalidPaymoney) {
        Input input = new Input();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> input.MoneyValidation(invalidPaymoney))
                .withMessage("구입 금액은 1000원 단위로 입력해주세요.");
    }

    @Test
    void 올바른_당첨_번호_입력() {
        List<Integer> actual = Input.NumberValidation(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(actual).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,50", "1,2,3,50,4,5"})
    void 잘못된_당첨_번호_입력(String invalidNumberList) {
        List<Integer> numbers = Input.Numbers(invalidNumberList);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Input.NumberValidation(numbers))
                .withMessage("당첨 번호는 1 이상 45 이하의 숫자이어야 합니다.");
    }
}
