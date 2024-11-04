package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lotto.common.Constants.MAIN_NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusNumberTest {
    private MainNumber mainNumber;

    @BeforeEach
    void 메인_넘버_생성() {
        mainNumber = new MainNumber("1,2,3,4,5,6");
    }

    @Test
    void 정상_동작() {
        BonusNumber bonusNumber = new BonusNumber("7", mainNumber);

        assertEquals(7, bonusNumber.getNumber());
    }

    @Test
    void 번호_범위_초과_예외() {

        assertThatThrownBy(() -> new BonusNumber("99", mainNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호_범위_미만_예외() {
        assertThatThrownBy(() -> new BonusNumber("0", mainNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메인_숫자와_중복_시_예외() {
        assertThatThrownBy(() -> new BonusNumber("1", mainNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
