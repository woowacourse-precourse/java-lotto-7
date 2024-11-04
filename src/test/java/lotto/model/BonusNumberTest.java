package lotto.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusNumberTest {

    @Test
    public void 보너스번호_반환_테스트() {
        BonusNumber bonusNumber = new BonusNumber(22);
        assertEquals(22, bonusNumber.getNumber());
    }
}
