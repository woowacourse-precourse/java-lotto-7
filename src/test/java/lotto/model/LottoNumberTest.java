package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @Test
    void 로또_번호를_생성할_수_있다() {
        // given
        LottoNumber lottoNumber = new LottoNumber();

        // when
        List<Integer> numbers = lottoNumber.generate();

        // then
        int real = numbers.size();
        int expected = 6;
        assertThat(real).isEqualTo(expected);
    }
}