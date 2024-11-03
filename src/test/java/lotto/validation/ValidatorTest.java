package lotto.validation;

import static org.assertj.core.api.Assertions.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    @DisplayName("문자열이 비어있으면 예외 발생 테스트")
    void isEmpty() {
        String empty = "";

        assertThatThrownBy(() -> {Validator.isEmpty(empty);}).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Validator.isEmpty(empty);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    }
}
