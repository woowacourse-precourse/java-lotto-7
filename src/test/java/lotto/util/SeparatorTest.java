package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SeparatorTest {

    @DisplayName("문자열을 쉼표 분리하여 Integer 리스트로 반환한다.")
    @Test
    void 쉼표로_분리된_문자열을_Integer_리스트로_변환한다() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = Separator.splitWithCommaToInteger(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("쉼표로 분리되지 않으면 예외가 발생한다.")
    @Test
    void 쉼표로_분리되지_않으면_예외가_발생한다() {
        String input = "1;2,3;4;5;6";

        assertThatThrownBy(() -> Separator.splitWithCommaToInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열에 숫자가 아닌 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_문자가_포함된_경우_예외가_발생한다() {
        String input = "1,2,three,4,5,6";

        assertThatThrownBy(() -> Separator.splitWithCommaToInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
