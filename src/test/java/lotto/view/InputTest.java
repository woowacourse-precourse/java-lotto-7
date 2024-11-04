package lotto.view;

import java.io.ByteArrayInputStream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {
    private Input input = new Input();

    @DisplayName("로또 번호가 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또_금액이_1000원_단위가_아니면_예외가_발생한다() {
        String inputAmount = "1500\n";
        System.setIn(new ByteArrayInputStream(inputAmount.getBytes()));

        assertThatThrownBy(() -> input.readLottoAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요");
    }

    @DisplayName("로또 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_금액이_숫자가_아니면_예외가_발생한다() {
        String inputAmount = "abc\n";
        System.setIn(new ByteArrayInputStream(inputAmount.getBytes()));

        assertThatThrownBy(() -> input.readLottoAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자만 입력해 주세요");
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_숫자가_아니면_예외가_발생한다() {
        String inputAmount = "a,1,2,3,4,5\n";
        System.setIn(new ByteArrayInputStream(inputAmount.getBytes()));

        assertThatThrownBy(() -> input.readWinningNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자만 입력해 주세요");
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        String inputAmount = "a\n";
        System.setIn(new ByteArrayInputStream(inputAmount.getBytes()));

        assertThatThrownBy(() -> input.readBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자만 입력해 주세요");
    }
}
