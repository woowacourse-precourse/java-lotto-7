package lotto.domain;

import lotto.constant.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {
    @Test
    @DisplayName("보너스 범위 검증")
    public void bonusRangeTest() {
        //given
        String bonus1 = String.valueOf(Constant.START_INCLUSIVE - 1);
        String bonus2 = String.valueOf(Constant.END_INCLUSIVE + 1);
        //expect
        assertThrows(IllegalArgumentException.class, () -> {new Bonus(bonus1);});
        assertThrows(IllegalArgumentException.class, () -> {new Bonus(bonus2);});
    }

    @Test
    @DisplayName("파라미터 변환 검증")
    public void bonusParseTest() {
        //given
        String bonus = "일";
        //expect
        assertThrows(IllegalArgumentException.class, () -> {new Bonus(bonus);});
    }

    @Test
    @DisplayName("보너스 내부 값 확인 테스트")
    public void getBonusTest() {
        //given
        String bonusNumber = "1";
        Bonus bonus = new Bonus(bonusNumber);
        //when
        int value = bonus.getBonus();
        //then
        assertEquals(value, 1);
    }
}