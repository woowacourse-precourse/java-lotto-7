package lotto.util;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import java.util.List;
import lotto.model.draw.Bonus;
import lotto.model.draw.LottoDraw;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.Test;
class LottoDrawTest {

    @Test
    void 당첨_번호와_중복() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(6);
        assertThatThrownBy(() -> LottoDraw.by(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage());
    }
}