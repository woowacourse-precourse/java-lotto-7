package lotto;

import lotto.model.Bonus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BonusTest {
    @Test
    public void 보너스_입력이_정상적으로_처리되는지_확인한다() {
        Bonus bonus = new Bonus("33");
        assertEquals(33, bonus.getBonusNumber());
    }

    @Test
    public void 보너스_번호가_범위를_넘기면_예외_처리한다(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Bonus("93");
        });
    }

}
