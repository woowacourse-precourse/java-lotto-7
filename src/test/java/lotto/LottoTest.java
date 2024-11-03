package lotto;

import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 번호에 중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("유효한 로또 번호 리스트를 생성하면 예외가 발생하지 않는다.")
    void 유효한_로또_번호_리스트를_생성하면_예외가_발생하지_않는다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("구입 금액이 0 이하이면 예외가 발생한다.")
    void 구입_금액이_0_이하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구입 금액은 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(1500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구입 금액은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("유효한 구입 금액으로 Money 객체를 생성하면 예외가 발생하지 않는다.")
    void 유효한_구입_금액으로_Money_객체를_생성하면_예외가_발생하지_않는다() {
        Money money = new Money(5000);
        assertThat(money.getAmount()).isEqualTo(5000);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    void 당첨_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 6))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("유효한 당첨 번호와 보너스 번호를 입력하면 예외가 발생하지 않는다.")
    void 유효한_당첨_번호와_보너스_번호를_입력하면_예외가_발생하지_않는다() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningLotto = new WinningNumbers(winningNumbers, 7);
        assertThat(winningLotto.getWinningNumbers()).hasSize(6);
        assertThat(winningLotto.getBonusNumber().getNumber()).isEqualTo(7);
    }
}
