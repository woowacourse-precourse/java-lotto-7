package lotto.domain.view;

import lotto.common.config.Factory;
import lotto.domain.model.lotto.Lotto;
import lotto.domain.model.lotto.LottoRank;
import lotto.domain.model.lotto.LottoSummary;
import lotto.domain.utils.TestLotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OutputViewTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Factory factory = new Factory();
    OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = factory.outputView();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @DisplayName("printLottos메서드는 사용자에게 생성된 로또와 개수를 출력해야 한다.")
    @Test
    void printLottos() {
        String prompt = "3개를 구매했습니다.";
        String format1 = "[1, 2, 3, 4, 5, 6]";
        String format2 = "[6, 5, 4, 3, 2, 1]";
        String format3 = "[1, 6, 2, 5, 3, 4]";

        Lotto lotto1 = TestLotto.createTestLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = TestLotto.createTestLotto(List.of(6, 5, 4, 3, 2, 1));
        Lotto lotto3 = TestLotto.createTestLotto(List.of(1, 6, 2, 5, 3, 4));
        List<Lotto> testLottos = TestLotto.createTestLottos(lotto1, lotto2, lotto3);

        outputView.printLottos(testLottos);

        assertEquals(String.format("%s\n%s\n%s\n%s\n", prompt, format1, format2, format3),
                outputStreamCaptor.toString());
    }

    @DisplayName("printLottoSummary메서드는 로또 당첨 결과를 정리하여 보여준다.")
    @Test
    void printLottoSummary() {
        //given
        int amount = 5000;
        LottoRank first = LottoRank.FIRST;
        LottoRank second = LottoRank.SECOND;
        LottoRank third = LottoRank.THIRD;
        LottoRank fourth = LottoRank.FOURTH;
        LottoRank fifth = LottoRank.FIFTH;
        HashMap<LottoRank, Long> resultMap = new HashMap<>();
        resultMap.put(first, 1L);
        resultMap.put(second, 1L);
        resultMap.put(third, 1L);
        resultMap.put(fourth, 1L);
        resultMap.put(fifth, 1L);
        LottoSummary testSummary = LottoSummary.create(resultMap);

        //when
        outputView.printLottoSummary(testSummary);

        assertEquals("3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n",
                outputStreamCaptor.toString());
    }
}