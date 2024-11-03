package lotto.domain.manager;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningLottosTest {

    @Test
    void 당첨_로또번호6개와_보너스번호가_중복되지않으면_객체가_생성된다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        //when
        WinningLottos winningLottos = new WinningLottos(lotto, bonusNumber);
        //then
        Assertions.assertThat(winningLottos).isNotNull();
    }

    @Test
    void 당첨_로또번호6개와_보너스번호는_중복되면_예외가발생한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(2);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new WinningLottos(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_로또번호에_다른_로또번호를_매칭하여_당첨된_개수를_반환해준다() {
        //given
        Lotto automaticLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto wininigLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLottos winningLottos = new WinningLottos(wininigLotto, new LottoNumber(45));
        int expectedMatchCount = wininigLotto.match(automaticLotto);
        //when
        int matchCount = winningLottos.match(automaticLotto);
        //then
        Assertions.assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    @Test
    void 당첨_로또의_보너스번호가_자동발권된_로또번호에_포함된다면_TRUE를_반환해준다() {
        //given
        int winningNumber = 45;
        Lotto automaticLotto = new Lotto(List.of(1, 2, 3, 4, 5, winningNumber));
        Lotto wininigLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLottos winningLottos = new WinningLottos(wininigLotto, new LottoNumber(winningNumber));
        //when
        boolean isMatchBonus = winningLottos.isMatchBonus(automaticLotto);
        //then
        Assertions.assertThat(isMatchBonus).isTrue();
    }

    @Test
    void 당첨_로또의_보너스번호가_자동발권된_로또번호에_포함되지_않으면_FALSE를_반환해준다() {
        //given
        Lotto automaticLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto wininigLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLottos winningLottos = new WinningLottos(wininigLotto, new LottoNumber(45));
        //when
        boolean isMatchBonus = winningLottos.isMatchBonus(automaticLotto);
        //then
        Assertions.assertThat(isMatchBonus).isFalse();
    }

}