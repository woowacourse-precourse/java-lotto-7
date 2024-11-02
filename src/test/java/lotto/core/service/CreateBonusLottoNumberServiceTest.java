package lotto.core.service;

import lotto.core.dto.LottoNumberDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateBonusLottoNumberServiceTest {

    private CreateBonusLottoNumberService service;

    @BeforeEach
    void setUp() {
        service = new CreateBonusLottoNumberService();
    }

    @Test
    void create_should_be_pass() {
        // given
        // when
        String value = "40";
        LottoNumberDto number = service.create(value);
        // then
        Assertions.assertEquals(40, number.value());
    }

    @Test
    void create_when_value_is_null_should_be_fail() {
        // given
        // when
        String value = null;
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value));
    }

    @Test
    void create_when_value_is_blank_should_be_fail() {
        // given
        // when
        String value = "   ";
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value));
    }

    @Test
    void create_when_value_is_nan_should_be_fail() {
        // given
        // when
        String value = "abc";
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value));
    }
}
