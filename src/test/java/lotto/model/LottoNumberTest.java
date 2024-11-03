package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;
import lotto.model.exception.DomainExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("같은 값을 가지면 같은 객체이다")
    void should_BeEqualInstance_When_GivenSameValue() {
        //given
        String number = "1";
        //when
        LottoNumber lottoNumber1 = new LottoNumber(number);
        LottoNumber lottoNumber2 = new LottoNumber(number);
        //then
        Assertions.assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }

    @Test
    @DisplayName("숫자가 들어오지 않으면 예외를 발생한다.")
    void should_ThrowException_When_NotGivenNumber() {
        //given
        String number = "우테코";
        //when, then
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("적절한 번위의 숫자가 들어오지 않으면 예외를 발생한다.")
    @ValueSource(strings = {"0", "46"})
    void should_ThrowException_When_NumberOutOfBound(String number) {
        //when, then
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.INVALID_NUMBER_VALUE.getMessage());
    }

}