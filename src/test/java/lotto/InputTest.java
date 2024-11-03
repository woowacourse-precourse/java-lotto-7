package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    @DisplayName("1000의 배수가 아닌 금액이 입력되면 예외가 발생한다.")
    void 천의_배수가_아닌_금액_입력_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseMoney("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이하의 금액이 입력되면 예외가 발생한다.(음수 포함)")
    void 숫자가_아닌_문자_입력_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제대로된 입력 검증 테스트")
    void 제대로된_금액_입력_시_int_반환() {
        assertThat(Input.parseMoney("1000")).isEqualTo(1000);
    }

    @Test
    @DisplayName("당첨 번호에 숫자와 쉽표 외의 문자가 있으면 예외가 발생한다.")
    void 당첨_번호에_숫자와_쉼표_외의_문자_입력_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseWinningLotto("1/2/3/4/5/6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 쉼표를 연속으로 입력하면 예외가 발생한다.")
    void 당첨_번호에_쉼표_연속_입력_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseWinningLotto("1,33,44,,2,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력이 쉼표로 끝나면 예외가 발생한다.")
    void 당첨_번호_입력이_쉼표로_끝나면_예외_발생() {
        assertThatThrownBy(() -> Input.parseWinningLotto("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에 숫자가 아닌 문자 입력 시 예외가 발생한다.")
    void 보너스_번호에_숫자_외의_문자_입력_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseBonusNumber("7!",
                new ParamDto.WinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에 1~45 외의 숫자 입력 시 예외가 발생한다.")
    void 보너스_번호에_로또_범위_넘는_숫자_입력_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseBonusNumber("65",
                new ParamDto.WinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복_시_예외_발생() {
        assertThatThrownBy(() -> Input.parseBonusNumber("6",
                new ParamDto.WinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
