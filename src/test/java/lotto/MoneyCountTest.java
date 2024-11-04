package lotto;

import java.util.List;
import lotto.controller.MoneyCount;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyCountTest {
    @Test
    void 돈을_숫자로_잘_세니 () {
        assertEquals(15, MoneyCount.countTimes(15000));
    }
}
