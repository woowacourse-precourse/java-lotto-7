package lotto.domain;

import java.util.Arrays;
import lotto.converter.StringToIntConverter;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private final StringToIntConverter converter = new StringToIntConverter();

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_범위를_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUM_OUT_OF_RANGE.getMsg());
    }

    @Test
    void 로또_번호_사이에_공백이_있어도_정상_입력된다() {
        // given
        String[] rawNumbers = "1,  2,  3   , 4  , 5   , 6".split(",");
        List<Integer> numbers = Arrays.stream(rawNumbers)
                .map(String::trim)
                .map(converter::convert)
                .toList();

        // when, then
        assertThat(new Lotto(numbers)).isInstanceOf(Lotto.class);
    }
}
