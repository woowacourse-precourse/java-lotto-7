package lotto.core.service;

import java.util.List;
import lotto.core.dto.LottoDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateWinningLottoServiceTest {

    private CreateWinningLottoService service;

    @BeforeEach
    void setUp() {
        service = new CreateWinningLottoService();
    }

    @Test
    void create_should_be_pass() {
        // given
        // when
        String value = "1,3,2,5,6,4";
        LottoDto lotto = service.create(value);
        // then
        List<Integer> expected = List.of(1,2,3,4,5,6);
        Assertions.assertEquals(expected, lotto.numbers());
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
    void create_when_value_is_평문_should_be_fail() {
        // given
        // when
        String value = "123456";
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value));
    }

    @Test
    void create_when_value_has_nan_should_be_fail() {
        // given
        // when
        String value = "1,2,a,3,b,5";
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value));
    }
}
