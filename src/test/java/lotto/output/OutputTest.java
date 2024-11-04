package lotto.output;

import lotto.LottoPrize;
import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class OutputTest {
    private PrintStream standardOut;
    private OutputStream captor;

    private final Output output = new Output();

    @BeforeEach
    protected final void init() {
        this.standardOut = System.out;
        this.captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(this.standardOut);
    }

    private String output() {
        return this.captor.toString().trim();
    }

    @Test
    void 입력_그대로_출력이_되어야_한다() {
        String expected = "입력";

        output.write("입력");
        Assertions.assertEquals(expected, output());
    }

    @Test
    void 수익률_출력은_소수점_형식의_가변_배열을_제대로_출력해야_한다() {
        Double number = 62.52;
        String format = "총 수익률은 %.1f%%입니다.";
        String expected = "총 수익률은 62.5%입니다.";

        output.write(format, number);

        Assertions.assertEquals(expected, output());
    }

    @Test
    void 여러개의_정수가_들어오면_알맞은_포멧으로_출력해야_한다() {
        String expected = "3개 일치 (40,000,000원) - 3개";
        output.write("%d개 일치 (%,d원) - %d개", 3, 40000000, 3);

        Assertions.assertEquals(expected, output());
    }

    @Test
    void 맵과_수익률이_주어지면_로또_결과를_정상적으로_출력해야_한다() {
        Map<LottoPrize, Integer> map = initializePrizeMap();
        map.put(LottoPrize.FIVE_MATCH, 3);
        double roi = 1030.54;

        String expected = """
                당첨 통계
                ---
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 3개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 1030.5%입니다.""";

        output.writeLottoPrize(map, roi);

        Assertions.assertEquals(expected, output());
    }

    @Test
    void 로또_리스트가_주어지면_정해진_형식으로_출력해야_한다() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottoList.add(new Lotto(List.of(1,2,3,4,5,7)));
        output.writeLottoList(convertLottoListToIntegerList(lottoList));

        String expected = """
                [1, 2, 3, 4, 5, 6]
                [1, 2, 3, 4, 5, 7]
                """;

    }

    private Map<LottoPrize, Integer> initializePrizeMap() {
        Map<LottoPrize, Integer> prizeMap = new LinkedHashMap<>();
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> prizeMap.put(prize, 0));
        return prizeMap;
    }

    private List<List<Integer>> convertLottoListToIntegerList(List<Lotto> lottoList) {
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
