package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    @Test
    void 로또_번호를_생성할_수_있다() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers();

        // when
        List<Integer> numbers = lottoNumbers.generate();

        // then
        int real = numbers.size();
        int expected = 6;
        assertThat(real).isEqualTo(expected);
    }
}