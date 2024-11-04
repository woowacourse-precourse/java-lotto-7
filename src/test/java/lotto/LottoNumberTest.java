package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void 범위_내의_랜덤_숫자를_반환한다() {
        //given
        int start = 1;
        int end = 45;

        //when
        List<Integer> lottoNumbers = LottoNumber.generate();

        //then
        assertThat(lottoNumbers)
                .allMatch(number -> number >= start && number <= end);
    }

}