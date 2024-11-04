package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.fixture.LottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoFixture.createLengthException(1, 2, 3, 4, 5, 6, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoFixture.create(1, 2, 3, 4, 5, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 보너스 번호를 포함하는지 확인한다.")
    @Test
    void 로또_번호가_보너스_번호를_포함하는지_확인한다() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        assertThat(lotto.hasBonus(3)).isTrue();
        assertThat(lotto.hasBonus(7)).isFalse();
    }

    @DisplayName("로또 번호 일치 개수를 확인한다.")
    @Test
    void 로또_번호_일치_개수를_확인한다() {
        Lotto lotto = LottoFixture.create(1, 2, 3, 4, 5, 6);
        Lotto winning = LottoFixture.create(4, 5, 6, 7, 8, 9);
        assertThat(lotto.countMatch(winning)).isEqualTo(3);
    }
}
