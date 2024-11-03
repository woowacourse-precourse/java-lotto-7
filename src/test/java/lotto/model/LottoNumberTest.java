package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 객체를 생성할 수 있다.")
    void should_CreateLottoNumber_When_GivenNumber() {
        //given
        String number = "1";
        //when
        LottoNumber lottoNumber = new LottoNumber(number);
        //then
        Assertions.assertThat(lottoNumber).isNotNull();
    }
}