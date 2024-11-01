package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class InputModelTest {

    @Test
    void 조건에_맞는_구입금액_문자열을_입력하면_금액을_숫자로_반환한다() {
        assertThat(InputModel.validatePrice("8000")).isEqualTo(8000);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "990:[ERROR] 구입금액은 1000원 이상이어야 합니다.",
            "14700:[ERROR] 구입금액은 1000원 단위여야 합니다.",
            "n:[ERROR] 숫자를 입력해야 합니다."
    }, delimiter = ':')
    void 구입금액_입력조건을_맞추지_않았을_경우_예외_테스트(String input, String errorMessage) {
        assertThatThrownBy(() -> InputModel.validatePrice(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @EmptySource
    @NullSource
    void 구입금액에_빈_값을_입력했을_경우_예외_테스트(String input) {
        assertThatThrownBy(() -> InputModel.validatePrice(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 입력입니다.");
    }
}
