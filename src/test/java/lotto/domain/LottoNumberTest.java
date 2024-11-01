package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {47,-1})
    void 로또_번호는_1에서_45의_숫자여야한다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
