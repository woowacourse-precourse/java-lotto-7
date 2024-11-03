package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private final LottoController lottoController = new LottoController();

    @Test
    void 지불_금액_기록_테스트() {
        // given
        setSystemInput("8000");

        // when
        String result = lottoController.recordPayment();

        // then
        assertThat(result).isEqualTo("success");
    }

    private void setSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
