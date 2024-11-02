package lotto.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void create_LottoNumber_should_be_pass() {
        // given
        // when
        LottoNumber number_1 = new LottoNumber(1);
        LottoNumber number_45 = new LottoNumber(45);
        // then
        Assertions.assertEquals(1, number_1.value());
        Assertions.assertEquals(45, number_45.value());
    }

    @Test
    void create_LottoNumber_when_value_is_0_should_be_fail() {
        // given
        // when
        Integer value = 0;
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoNumber(value));
    }

    @Test
    void create_LottoNumber_when_value_is_46_should_be_fail() {
        // given
        // when
        Integer value = 46;
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoNumber(value));
    }
}
