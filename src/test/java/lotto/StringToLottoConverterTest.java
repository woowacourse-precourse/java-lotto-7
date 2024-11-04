package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.StringToLottoConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringToLottoConverterTest {
    @DisplayName("올바른 로또 번호 입력 테스트")
    @Test
    void 올바른_로또_번호_입력_테스트() {
        String input = "1,2,3,4,5";

        List<Integer> result = StringToLottoConverter.convert(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("구분자가 쉼표가 아니면 예외가 발생한다.")
    @Test
    void 구분자가_쉼표가_아니면_예외가_발생한다() {
        String input = "1;2;3;4;5";

        assertThatThrownBy(() -> StringToLottoConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자는 ','이어야 합니다.");
    }

    @DisplayName("숫자로 변환할 수 없는 문자가 존재하면 예외가 발생한다.")
    @Test
    void 숫자로_변환할_수_없는_문자가_존재하면_예외가_발생한다() {
        String input = "1,a,3";

        assertThatThrownBy(() -> StringToLottoConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로 변환할 수 없는 값이 포함되어 있습니다.");
    }
}
