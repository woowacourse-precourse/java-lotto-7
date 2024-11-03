package lotto.validation;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    @DisplayName("문자열이 비었는지 확인하는 테스트")
    void isEmpty() {
        String empty = "";

        assertThatThrownBy(() -> {Validator.isEmpty(empty);}).isInstanceOf(IllegalArgumentException.class);
    }
}
