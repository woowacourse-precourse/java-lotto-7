package lotto.controller;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @DisplayName("구입금액이 1000원 단위가 아니면 예외를 반환한다.")
    @Test
    void 구입금액이_1000원_단위가_아니면_예외를_반환한다() {
        LottoController lottoController = new LottoController();
        String input = "6500";
        inputCommands(input);

        assertThatThrownBy(() -> lottoController.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 구입금액이 숫자가 아니면 예외를 반환한다.")
    @Test
    void 입력한_구입금액이_숫자가_아니면_예외를_반환한다() {
        LottoController lottoController = new LottoController();
        String input = "error";
        inputCommands(input);

        assertThatThrownBy(() -> lottoController.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 당첨번호가 숫자가 아니면 에외를 발생한다.")
    @Test
    void 입력한_당첨번호가_숫자가_아니면_예외를_발생한다() {
        LottoController lottoController = new LottoController();
        String inputCost = "6000";
        String inputWinningNumbers = "1,2,3,4,5,6,t";

        inputCommands(inputCost, inputWinningNumbers);

        assertThatThrownBy(() -> lottoController.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    private void inputCommands(final String... args) {
        final byte[] bytes = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(bytes));
    }
}
