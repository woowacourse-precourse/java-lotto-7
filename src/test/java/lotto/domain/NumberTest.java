package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void 동등성_테스트() {
        //given
        Number number1 = new Number("1");
        Number number2 = new Number("1");

        //when & then
        Assertions.assertThat(number1.equals(number2)).isTrue();
    }

}