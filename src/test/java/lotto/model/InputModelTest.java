package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @Test
    void 조건에_맞는_당첨번호_문자열을_입력하면_숫자_리스트를_반환한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(InputModel.convertText("1,2,3,4,5,6")).isEqualTo(numbers);
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

    @Test
    void 당첨번호에_쉼표를_제외한_알_수_없는_문자를_입력할_경우_예외_테스트() {
        assertThatThrownBy(() -> InputModel.convertText("1/2/3/4/5/6")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 각 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
    }

    @ParameterizedTest
    @EmptySource
    @NullSource
    void 당첨번호에_빈_값을_입력했을_경우_예외_테스트(String input) {
        assertThatThrownBy(() -> InputModel.convertText(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 입력입니다.");
    }
}
