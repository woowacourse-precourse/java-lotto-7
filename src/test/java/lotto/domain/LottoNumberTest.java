package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 정상적으로_로또_번호_클래스_생성() {
        // given
        int number = 8;

        // when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        assertThat(lottoNumber.getNumber()).isEqualTo(8);
    }

    @Test
    void toString_확인() {
        // given
        Integer number = 8;

        // when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        assertThat(lottoNumber.toString()).hasToString("LottoNumber{number=8}");
    }

    @Test
    void 예외_로또_번호가_1보다_작을_경우() {
        // given
        int number = 0;

        // when & then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 예외_로또_번호가_45보다_클_경우() {
        // given
        int number = 46;

        // when & then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 예외_로또_번호가_null_값일_경우() {
        // given
        Integer number = null;

        // when & then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 번호 값입니다.");
    }
}