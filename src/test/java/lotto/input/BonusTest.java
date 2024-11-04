package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusTest {

    @Test
    void 보너스_번호_정상_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(lotto, 7);

        //when, then
        assertThat(7).isEqualTo(bonus.getBonus());
    }

    @Test
    void 보너스_번호_범위_초과_예외_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when, then
        assertThatThrownBy(() -> new Bonus(lotto, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_번호_예외_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when, then
        assertThatThrownBy(() -> new Bonus(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}