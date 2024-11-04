package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import lotto.utils.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoNumberTest {

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5,5";
        String bonusNumber = "6";

        assertThatThrownBy(() -> new WinningLottoNumber(Parser.parseWinningNumber(winningNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호에 중복이 존재합니다.");
    }

    @DisplayName("보너스 번호가 당첨번호와 중복이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨번호와_중복이면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "6";

        assertThatThrownBy(() -> new WinningLottoNumber(Parser.parseWinningNumber(winningNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
    }

    @DisplayName("잘못된 당첨 번호 형식이 입력되면 예외가 발생한다.(빈문자열)")
    @Test
    void 잘못된_당첨_번호_형식이_입력되면_예외가_발생한다_빈문자열() {
        String winningNumbers = "1,2,3,,5,6";
        String bonusNumber = "7";

        assertThatThrownBy(() -> new WinningLottoNumber(Parser.parseWinningNumber(winningNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효한 당첨 번호를 입력해주세요.");
    }

    @DisplayName("잘못된 당첨 번호 형식이 입력되면 예외가 발생한다.(구분자)")
    @Test
    void 잘못된_당첨_번호_형식이_입력되면_예외가_발생한다_구분자() {
        String winningNumbers = "1,2,3,4,5.6";
        String bonusNumber = "7";

        assertThatThrownBy(() -> new WinningLottoNumber(Parser.parseWinningNumber(winningNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효한 당첨 번호를 입력해주세요.");
    }

    @DisplayName("잘못된 보너스 번호 형식이 입력되면 예외가 발생한다.")
    @Test
    void 잘못된_보너스_번호_형식이_입력되면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "abc";

        assertThatThrownBy(() -> new WinningLottoNumber(Parser.parseWinningNumber(winningNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효한 보너스 번호를 입력해주세요.");
    }

    @DisplayName("정상적인 당첨 번호와 보너스 번호가 입력되면 객체가 정상적으로 생성된다.")
    @Test
    void 정상적인_당첨_번호와_보너스_번호가_입력되면_객체가_정상적으로_생성된다() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(Parser.parseWinningNumber(winningNumbers),
                bonusNumber);

        assertThat(winningLottoNumber.getWinningNumber()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLottoNumber.getBonusNumber()).isEqualTo(7);
    }
}