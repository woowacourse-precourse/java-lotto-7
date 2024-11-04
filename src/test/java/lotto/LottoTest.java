package lotto;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호가 6개 미만이면 예외가 발생한다.")
    @Test
    void 로또_번호가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호랑 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_로또_번호랑_중복되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))); // Create a mutable list
        int bonusNumber = 6;
        assertThatThrownBy(() -> winningLotto.checkForBonusNumberDuplicates(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1에서 45사이가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_1에서_45사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5 ,56)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5 ,0)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("금액이 1000원 단위가 아닐경우 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아닐경우_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
