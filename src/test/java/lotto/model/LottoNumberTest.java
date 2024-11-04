package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 로또_번호의_범위는_1부터_45_까지다() {
        int number = 46;

        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1 부터 45 사이여야 합니다.");
    }

    @Test
    void 로또_번호는_숫자여야_한다() {
        String number = "aa";

        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 정수여야 합니다.");
    }


}
