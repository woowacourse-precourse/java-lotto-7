package lotto.store.winning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.store.user.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    private final Lotto lotto = Lotto.from(List.of(1,2,3,4,5,6));
    private final BonusNumber bonusNumber = BonusNumber.from(7);
    private final WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);

    @Test
    void 우승_로또와_일치하는_당첨_번호의_개수를_계산한다() {
        //given
        Lotto lotto = Lotto.from(List.of(1,2,3,4,5,7));

        //when
        int actual = winningLotto.matchCount(lotto);

        //then
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void 우승_로또와_일치하는_당첨_번호의_개수가_5이고_보너스_번호가_일치하면_TRUE를_반환한다() {
        //given
        int matchCount = 5;
        Lotto lotto = Lotto.from(List.of(1,2,3,4,5,7));

        //when
        boolean actual = winningLotto.matchBonus(matchCount, lotto);

        //then
        assertTrue(actual);
    }

    @Test
    void 우승_로또와_일치하는_당첨_번호의_개수가_5이고_보너스_번호가_불일치하면_FALSE를_반환한다() {
        //given
        int matchCount = 5;
        Lotto lotto = Lotto.from(List.of(1,2,3,4,5,9));

        //when
        boolean actual = winningLotto.matchBonus(matchCount, lotto);

        //then
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,6})
    void 우승_로또와_일치하는_당첨_번호의_개수가_5가_아니면_FALSE를_반환한다(int matchCount) {
        //given
        Lotto lotto = Lotto.from(List.of(1,2,3,4,5,9));

        //when
        boolean actual = winningLotto.matchBonus(matchCount, lotto);

        //then
        assertFalse(actual);
    }

}
