package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CliOutputView 테스트")
public class CliOutputViewTest {

    private CliOutputView cliOutputView;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        cliOutputView = new CliOutputView();

        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        originalOut = System.out;
        System.setOut(printStream);
    }

    @Test
    void 구매한_로또를_오름차순으로_출력한다() {
        //given
        Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(6, 2, 3, 4, 5, 1)),
            new Lotto(List.of(1, 2, 3, 4, 8, 5))
        ));

        //when
        cliOutputView.printLottos(lottos);

        //then
        assertEquals("""
                2개를 구매했습니다.
                [1, 2, 3, 4, 5, 6]
                [1, 2, 3, 4, 5, 8]
                """.replace("\n", System.lineSeparator()),
            outputStream.toString());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

}
