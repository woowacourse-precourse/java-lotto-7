package lotto;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

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

    @DisplayName("구입금액에 아무것도 입력하지 않을 때 예외가 발생한다")
    @Test
    void 구입금액에_아무것도_입력을_하지_않을때_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.inputIsEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액을 입력해주셔야 합니다.");
    }

    @DisplayName("구입금액이 0원보다 적을 때 예외가 발생한다")
    @Test
    void 구입금액이_0원보다_적을때_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.moneyUnderZero(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 0원 초과이어야 합니다.");
    }

    @DisplayName("당첨 번호에 아무것도 입력되지 않으면 예외가 발생한다")
    @Test
    void 당첨번호에_아무것도_입력되지_않으면_예외_발생() {
        assertThatThrownBy(() -> InputView.inputWinningNumberIsEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열이 입력되었습니다.");
    }

    @DisplayName("당첨 번호가 범위 밖의 숫자일 경우 예외가 발생한다")
    @Test
    void 당첨번호가_범위_밖의_숫자일_경우_예외_발생() {
        assertThatThrownBy(() -> InputView.outOfRangeNumber(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1~45 사이의 숫자로 이루어져 있습니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void 당첨번호에_중복된_숫자가_있으면_예외_발생() {
        assertThatThrownBy(() -> InputView.findSameNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복되는 숫자가 입력되었습니다.");
    }

    @DisplayName("당첨 번호에 6개의 숫자가 입력되지 않으면 예외가 발생한다")
    @Test
    void 당첨번호에_6개의_숫자가_입력되지_않으면_예외_발생() {
        assertThatThrownBy(() -> InputView.countWinningNumber(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 6개가 입력되지 않았습니다.");
    }

    @DisplayName("보너스 번호가 범위 밖의 숫자가 입력되면 예외가 발생한다")
    @Test
    void 보너스_번호에_범위_밖의_숫자가_입력되면_예외_발생() {
        assertThatThrownBy(() -> InputView.checkBonusNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1~45 사이의 숫자로 이루어져야 합니다.");
    }
}
