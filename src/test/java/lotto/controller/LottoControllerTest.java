package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.handler.InputHandler;
import lotto.handler.LottoHandler;
import lotto.handler.OutputHandler;

public class LottoControllerTest {
    private LottoController controller;

    @BeforeEach
    void 테스트를_위한_객체_초기화() {
        controller = new LottoController(new InputHandler(),
                new OutputHandler(), new LottoHandler());
    }

    @Test
    void 당첨_번호와_중복되는_로또_번호의_수를_이용하여_당첨_종류를_판별할_수_있다() {
        // controller.
        // 보류
    }
}
