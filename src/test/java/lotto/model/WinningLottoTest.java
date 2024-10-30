package lotto.model;

import lotto.dto.WinningLottoInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    private WinningLotto winningLotto;

    @DisplayName("당첨번호와 보너스번호 정상 입력")
    @Test
    void 당첨번호와_보너스번호_정상입력() {
        // given
        WinningLottoInfo validWinningLottoInfo = new WinningLottoInfo("1,2,3,4,5,6", 10);

        // when, then
        winningLotto = new WinningLotto(validWinningLottoInfo);
    }

    @DisplayName("당첨번호의 구분자가 쉼표가 아니면 예외발생")
    @Test
    void 당첨번호의_구분자가_쉼표가_아니면_예외발생() {
        // given
        WinningLottoInfo invalidDelimiterWinningLottoInfo = new WinningLottoInfo("1.2.3.4.5.6", 10);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(invalidDelimiterWinningLottoInfo))
                .withMessage("[ERROR] 당첨번호를 숫자로만 입력해주세요.");
    }

    @DisplayName("당첨번호가 1~45 사이의 숫자가 아니면 예외발생")
    @Test
    void 당첨번호가_1_45_사이의_숫자가_아니면_예외발생() {
        // given
        WinningLottoInfo invalidNumberWinningLottoInfo = new WinningLottoInfo("1,2,3,4,5,66", 10);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(invalidNumberWinningLottoInfo))
                .withMessage("[ERROR] 1~45 사이의 수만 가능합니다.");
    }

    @DisplayName("당첨번호가 중복되면 예외발생")
    @Test
    void 당첨번호가_중복되면_예외발생() {
        // given
        WinningLottoInfo invalidNumberWinningLottoInfo = new WinningLottoInfo("1,1,1,1,1,1", 10);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(invalidNumberWinningLottoInfo))
                .withMessage("[ERROR] 숫자가 중복되면 안됩니다.");
    }

    @DisplayName("당첨번호가 숫자가 아니면 예외발생")
    @Test
    void 당첨번호가_숫자가_아니면_예외발생() {
        // given
        WinningLottoInfo invalidNumberWinningLottoInfo = new WinningLottoInfo("one,two,three,four,five,six", 10);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(invalidNumberWinningLottoInfo))
                .withMessage("[ERROR] 당첨번호를 숫자로만 입력해주세요.");
    }

    @DisplayName("당첨번호가 6개가 아니면 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "12,3,4,5,6,7,8"})
    void 당첨번호가_6개가_아니면_예외발생(String invalidLengthWinningNumber) {
        // given
        WinningLottoInfo invalidNumberWinningLottoInfo = new WinningLottoInfo(invalidLengthWinningNumber, 10);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(invalidNumberWinningLottoInfo))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨번호에 공백이 포함되면 예외발생")
    @Test
    void 당첨번호에_공백이_포함되면_예외발생() {
        // given
        WinningLottoInfo invalidNumberWinningLottoInfo = new WinningLottoInfo("1,2,3,4,5 ,6", 10);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(invalidNumberWinningLottoInfo))
                .withMessage("[ERROR] 당첨번호를 숫자로만 입력해주세요.");
    }

}