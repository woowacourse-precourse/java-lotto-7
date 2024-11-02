package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.utils.ConstantMessage.GuideMessage;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    void testPrintLottoNumber() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        assertSimpleTest(() -> outputView.printLottoNumber(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(outputStream.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        System.setOut(System.out);
    }

    @Test
    void testPrintGuide() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        assertSimpleTest(() -> outputView.printGuide(GuideMessage.INPUT_PRICE));
        assertThat(outputStream.toString()).isEqualTo("구입금액을 입력해 주세요.");
        System.setOut(System.out);
    }
}
