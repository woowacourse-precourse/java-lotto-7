package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 정상적으로 생성한다.")
    @Test
    void 로또를_정상적으로_생성한다() {
        //given
        Lotto lotto = new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)));

        //when & then
        assertThat(lotto).isNotNull();
    }

    @Test
    void 두_리스트의_공통값의_개수는_올바르게_나와야한다() {
        //given
        Lotto lotto = new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)));
        Lotto winningLotto = new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)));

        //when
        int matchCount = winningLotto.matchCount(lotto);

        //then
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    void 보너스_번호가_있다면_참을_반환해야한다() {
        //given
        Lotto lotto = new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)));
        LottoNumber bonusNumber = new LottoNumber(6);

        //when
        boolean hasBonusNumber = lotto.matchBonusNumber(bonusNumber);
        //then
        assertThat(hasBonusNumber).isEqualTo(true);
    }

    @Test
    void 보너스_번호가_없다면_거짓을_반환해야한다() {
        //given
        Lotto lotto = new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)));
        LottoNumber bonusNumber = new LottoNumber(7);

        //when
        boolean hasBonusNumber = lotto.matchBonusNumber(bonusNumber);
        //then
        assertThat(hasBonusNumber).isEqualTo(false);
    }
}
