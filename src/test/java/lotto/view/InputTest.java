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
        // 가상 입력을 설정
        String inputAmount = "abc\n";
        System.setIn(new ByteArrayInputStream(inputAmount.getBytes()));

        assertThatThrownBy(() -> input.readLottoAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자만 입력해 주세요");
    }
}
