package lotto.value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;
    public static final String ERROR_HEADER = "[ERROR]";

    @Test
    void 한줄의_로또번호를_생성한다() {
        assertThatCode(() -> new LottoNumbers(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ))).doesNotThrowAnyException();

        assertThat(new LottoNumbers(List.of(
                new LottoNumber(6), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(1)
        ))).isEqualTo(new LottoNumbers(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        )));

        assertThatCode(() -> new LottoNumbers(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5)
        )))
                .isInstanceOf(COMMON_EXCEPTION)
                .hasMessageContaining(ERROR_HEADER);

        assertThatCode(() -> new LottoNumbers(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6),
                new LottoNumber(7)
        )))
                .isInstanceOf(COMMON_EXCEPTION)
                .hasMessageContaining(ERROR_HEADER);

        assertThatCode(() -> new LottoNumbers(List.of(
                new LottoNumber(1), new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5)
        )))
                .isInstanceOf(COMMON_EXCEPTION)
                .hasMessageContaining(ERROR_HEADER);
    }

}