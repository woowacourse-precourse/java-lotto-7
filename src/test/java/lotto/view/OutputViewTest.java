package lotto.view;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("생성한 로또 출력 테스트")
    @Test
    void 생성한_로또_출력_테스트() {
        List<Lotto> lotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18)),
                new Lotto(List.of(19, 20, 21, 22, 23, 24)),
                new Lotto(List.of(25, 26, 27, 28, 29, 30)),
                new Lotto(List.of(31, 32, 33, 34, 35, 36)),
                new Lotto(List.of(37, 38, 39, 40, 41, 42)),
                new Lotto(List.of(43, 44, 45, 1, 2, 3))
        );

        OutputView.printLotto(lotto);

        String expectedOutput = String.join(System.lineSeparator(),
                "8개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[13, 14, 15, 16, 17, 18]",
                "[19, 20, 21, 22, 23, 24]",
                "[25, 26, 27, 28, 29, 30]",
                "[31, 32, 33, 34, 35, 36]",
                "[37, 38, 39, 40, 41, 42]",
                "[43, 44, 45, 1, 2, 3]",
                "");

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
