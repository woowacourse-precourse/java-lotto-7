package lotto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.view.LottoView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoControllerTest {
    LottoController lottoController;
    LottoValue lottoValue;
    LottoView lottoView;
    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottoView = new LottoView();
        lottos = new Lottos();
        lottoValue = new LottoValue(BigDecimal.valueOf(8000));
        lottoController = new LottoController(lottos, lottoView, lottoValue);
    }

    @Test
    void 로또_갯수_출력_및_로또_할당_번호_출력() {
        PrintStream out = System.out;

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        lottoController.setAndPrintLottos();

        String output = "8개를 구매했습니다.\r\n"
                + lottos.toStringAllLottoNumber()
                + "\r\n";

        assertEquals(output, stream.toString());

        System.setOut(out);
    }

    @Test
    void 당첨_번호_입력_테스트() {
        InputStream in = System.in;

        ByteArrayInputStream stream = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(stream);

        List<Integer> winningNumber = lottoController.getWinningNumber();

        assertEquals(List.of(1,2,3,4,5,6), winningNumber);

        System.setIn(in);
    }

    @Test
    void 보너스_번호_입력_테스트() {
        InputStream in = System.in;

        ByteArrayInputStream stream = new ByteArrayInputStream("5".getBytes());
        System.setIn(stream);

        int bonusNumber = lottoController.getBonusNumber();

        assertEquals(5, bonusNumber);

        System.setIn(in);
    }

    @Test
    void 당첨_내역_출력_테스트() {
        PrintStream out = System.out;

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        IntStream.range(0, 8).forEach(i ->
                lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 11, 22, 33), Lotto::new));
        lottoController.confirmWinning(List.of(1,2,3,4,5,6), 7);

        String output = """
                당첨 통계
                ---
                3개 일치 (5,000원) - 8개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                
                """;

        assertEquals(output.replaceAll("\\r\\n", "\n"), stream.toString().replaceAll("\\r\\n", "\n"));
        System.setOut(out);
    }

    @Test
    void 수익률_출력_테스트() {
        PrintStream out = System.out;

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        IntStream.range(0, 8).forEach(i ->
                lottos.allocateLottosByRandomNumber(List.of(1, 2, 3, 11, 22, 33), Lotto::new));
        lottos.setByCorrectCount(List.of(1, 2, 3, 4, 5, 6), 7);

        lottoController.printAndCalculateWinningRate();

        String output = "총 수익률은 500%입니다.";

        assertEquals(output.trim(), stream.toString().trim());
        System.setOut(out);
    }
}