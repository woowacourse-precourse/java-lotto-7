package lotto.domain.winning;

import static lotto.constant.Error.RANGE_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("로또의 보너스 번호 적중 성공을 판단할 수 있다.")
    @Test
    void 로또의_보너스_번호_적중_성공을_판단할_수_있다() throws Exception {
        BonusNumber bonusNumber = new BonusNumber(5);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(bonusNumber.hits(lotto)).isTrue();
    }

    @DisplayName("로또의 보너스 번호 적중 실패를 판단할 수 있다.")
    @Test
    void 로또의_보너스_번호_적중_실패를_판단할_수_있다() throws Exception {
        BonusNumber bonusNumber = new BonusNumber(7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(bonusNumber.hits(lotto)).isFalse();
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1보다_작으면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> new BonusNumber(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(RANGE_BONUS_NUMBER);
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void 보너스_번호가_45보다_크면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> new BonusNumber(46))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(RANGE_BONUS_NUMBER);
    }
}