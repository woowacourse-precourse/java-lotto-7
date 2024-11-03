package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoApplicationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoNumberTest {

    @ValueSource(ints = {-1, 0, 46})
    @ParameterizedTest
    void 유효한_로또_번호가_아니면_예외가_발생한다(int number) {
        // when & then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}
