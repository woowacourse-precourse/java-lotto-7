package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static lotto.common.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainNumberTest {
    @Test
    void 정상_동작() {
        MainNumber mainNumber = new MainNumber("1,2,3,4,5,6");
        assertEquals(MAIN_NUMBER_SIZE, mainNumber.getNumbers().size());
        assertEquals(21, mainNumber.getNumbers().stream()
                .mapToInt(Integer::intValue).sum());
    }

    @Test
    void 번호_개수_6개_체크() {
        assertThatThrownBy(() -> new MainNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호_범위_초과_예외() {
        assertThatThrownBy(() -> new MainNumber("99,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호_범위_미만_예외() {
        assertThatThrownBy(() -> new MainNumber("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 중복_체크() {
        assertThatThrownBy(() -> new MainNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
