package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CommonValidationTest {
    @Test
    void 입력값이_Integer_형식이_아니면_에러가_난다() {
        String input1 = "input";
        assertThatThrownBy(() -> CommonValidation.convertStringToInt(input1))
                .isExactlyInstanceOf(IllegalArgumentException.class);

        String input2 = "123456789123456789";
        assertThatThrownBy(() -> CommonValidation.convertStringToInt(input2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_Integer_형식이면_반환한다() {
        String input = "134239";
        assertThat(CommonValidation.convertStringToInt(input))
                .isEqualTo(134239);
    }
}
