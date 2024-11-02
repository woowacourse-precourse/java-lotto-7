package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호가_1부터_45_가_아니면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호를_조회하는_기능_테스트() {
        for (int i = 1; i <= 45; i++) {
            LottoNumber lottoNumber = LottoNumber.valueOf(i);
            assertThat(lottoNumber.getNumber()).isEqualTo(i);
        }
    }
}
