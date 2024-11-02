package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sun.tools.javac.Main;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
