package lotto.view.output;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPurchaseListPrinterTest {

    @Test
    @DisplayName("구매한 로또 목록 출력 테스트")
    void testOutput() {
        LottoPurchaseListPrinter printer = new LottoPurchaseListPrinter();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<Lotto> lotteryTickets = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        printer.output(lotteryTickets);

        String expectedOutput = "2개를 구매했습니다." + System.lineSeparator() +
            "[1, 2, 3, 4, 5, 6]" + System.lineSeparator() +
            "[7, 8, 9, 10, 11, 12]" + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out); // 원래의 System.out으로 복원
    }
}