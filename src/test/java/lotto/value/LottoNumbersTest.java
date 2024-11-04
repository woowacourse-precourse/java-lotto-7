package lotto.value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import lotto.lottoapp.model.value.LottoNumbers;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;
    public static final String ERROR_HEADER = "[ERROR]";

    @Test
    void 한줄의_로또숫자들을_생성한다() {
        assertThatCode(() -> LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
        assertThat(LottoNumbers.of(List.of(6, 2, 3, 4, 5, 1)))
                .isEqualTo(LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6)));

        assertThatCode(() -> LottoNumbers.of(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(COMMON_EXCEPTION)
                .hasMessageContaining(ERROR_HEADER);
        assertThatCode(() -> LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(COMMON_EXCEPTION)
                .hasMessageContaining(ERROR_HEADER);
        assertThatCode(() -> LottoNumbers.of(List.of(1, 1, 3, 4, 5, 6)))
                .isInstanceOf(COMMON_EXCEPTION)
                .hasMessageContaining(ERROR_HEADER);
    }

    @Test
    void 같은_로또숫자들의_동등비교가_가능하다() {
        LottoNumbers number1 = LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers number2 = LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        assertThat(number1).isEqualTo(number2);
        assertThat(number1.equals(number2)).isTrue();
    }

}