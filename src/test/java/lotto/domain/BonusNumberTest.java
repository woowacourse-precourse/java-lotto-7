package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.number.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("로또 번호에 보너스번호가 포함 되어 true를 반환 한다.")
    @Test
    void isMatchNumberTest_true() {
        //given
        final BonusNumber bonusNumber = new BonusNumber(2);
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        final boolean matchNumber = bonusNumber.isMatchNumber(lotto);

        //then
        assertThat(matchNumber).isTrue();
    }

    @Test
    @DisplayName("로또 번호에 보너스번호가 포함 되어 있지 않아 false를 반환 한다.")
    void isMatchNumberTest_false() {
        //given
        final BonusNumber bonusNumber = new BonusNumber(10);
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        final boolean matchNumber = bonusNumber.isMatchNumber(lotto);

        //then
        assertThat(matchNumber).isFalse();
    }
}
