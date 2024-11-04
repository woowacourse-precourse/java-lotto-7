package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class OutputManagerTest {
    @Test
    void 구입한_로또_개수_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputManager.printLottoCount(8);

        assertThat(outputStream.toString()).contains("8개를 구매했습니다.");

        System.setOut(System.out);
    }

    @Test
    void 구입한_로또_번호_목록_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<List<Integer>> lottoTickets = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );

        OutputManager.printLottoTickets(lottoTickets);

        String actualOutput = outputStream.toString();
        assertThat(actualOutput).contains(
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]"
        );

        System.setOut(System.out);
    }

}

