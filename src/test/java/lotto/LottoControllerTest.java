package lotto;

import java.io.ByteArrayInputStream;
import lotto.controller.LottoController;
import org.junit.jupiter.api.Test;

public class LottoControllerTest {
    @Test
    public void 로또구매_테스트() {
        LottoController controller = new LottoController();
        String input = "3000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        controller.purchaseLotto();
    }
}
