package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest(name = "{0}은 예외발생")
    @ValueSource(ints = {0, 46})
    void 범위_밖의_로또_번호는_예외를_발생시킨다(Integer number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }

    @Test
    void 로또_번호가_같은지_비교할_수_있다() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
        assertThat(new LottoNumber(2)).isNotEqualTo(new LottoNumber(1));
    }
}
