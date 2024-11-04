package lotto.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LottoBonusNumberTest {




    @Test
    @DisplayName("여러 번의 요청에도 같은 객체를 반환하는지 확인한다.")
    void getInstance() {

        LottoBonusNumber bonusNumber01 = LottoBonusNumber.getInstance(7);
        assertNotNull(bonusNumber01);

        LottoBonusNumber bonusNumber02=LottoBonusNumber.getInstance(6);
        assertSame(bonusNumber01,bonusNumber02);
    }

    @Test
    @DisplayName("보너스 번호를 반환하는지 확인한다.")
    void getBonusNumber() {
        LottoBonusNumber bonusNumber = LottoBonusNumber.getInstance(7);
        assertEquals(7,bonusNumber.getBonusNumber());
    }

    @Test
    @DisplayName("보너스 번호가 1~45 사이의 숫자인지 확인한다.")
    void isValidBonusNumber() {
        assertThrows(IllegalArgumentException.class,()->LottoBonusNumber.getInstance(0));
        assertThrows(IllegalArgumentException.class,()->LottoBonusNumber.getInstance(46));
    }


}