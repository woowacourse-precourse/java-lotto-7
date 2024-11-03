package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private final LottoController lottoController = new LottoController();

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @Test
    void 지불_금액_기록_테스트() {
        // given
        setSystemInput("8000");

        // when
        Integer result = lottoController.recordPayment();

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 로또_발행_성공_테스트() {
        // given
        setSystemInput("8000");
        Integer customerId = lottoController.recordPayment();

        // when
        String result = lottoController.issueLottos(customerId);

        // then
        assertThat(result).isEqualTo("success");
    }

    private void setSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
