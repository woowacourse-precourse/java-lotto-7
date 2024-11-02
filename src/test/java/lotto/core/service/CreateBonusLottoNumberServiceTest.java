package lotto.core.service;

import java.util.List;
import lotto.core.dto.LottoDto;
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
        LottoDto winning = new LottoDto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumberDto number = service.create(value, winning);
        // then
        Assertions.assertEquals(40, number.value());
    }

    @Test
    void create_when_value_is_null_should_be_fail() {
        // given
        // when
        String value = null;
        LottoDto winning = new LottoDto(List.of(1, 2, 3, 4, 5, 6));
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value, winning));
    }

    @Test
    void create_when_value_is_blank_should_be_fail() {
        // given
        // when
        String value = "   ";
        LottoDto winning = new LottoDto(List.of(1, 2, 3, 4, 5, 6));
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value, winning));
    }

    @Test
    void create_when_value_is_nan_should_be_fail() {
        // given
        // when
        String value = "abc";
        LottoDto winning = new LottoDto(List.of(1, 2, 3, 4, 5, 6));
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value, winning));
    }

    @Test
    void create_when_winningLotto_contains_bonusNumber_should_be_fail() {
        // given
        // when
        String value = "5";
        LottoDto winning = new LottoDto(List.of(1, 2, 3, 4, 5, 6));
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(value, winning));
    }
}
