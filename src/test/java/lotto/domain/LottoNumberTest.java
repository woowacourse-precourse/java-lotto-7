package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 100})
    void 로또_번호가_1과_45_사이의_값이_아니면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
