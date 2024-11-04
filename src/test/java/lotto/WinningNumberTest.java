package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @Test
    void 로또_당첨_번호와_보너스_번호가_중복되면_IllegalArgumentException_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(lotto, bonusNumber));

    }
}
