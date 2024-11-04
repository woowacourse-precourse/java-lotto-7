package lotto;

import lotto.model.Lotto;
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

    @DisplayName("당첨 번호와 보너스 번호가 중복될 경우 예외가 발생한다.")
    @Test
    void 로또_번호와_당첨_번호가_중복될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.validateDuplicationBetweenWinningAndBonus(List.of(1, 2, 3, 4, 5, 6), 1)) // 보너스 번호와 중복
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45 사이가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또번호가_1부터_45사이가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.validateRange(List.of(0, 1, 2, 3, 4, 5))) // 0
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.validateRange(List.of(1, 2, 3, 4, 5, 46))) // 46
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구입금액이_1천원단위가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.validateUnit(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 입력값이_숫자가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.parseInt("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
