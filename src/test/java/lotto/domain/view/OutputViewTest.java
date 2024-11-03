package lotto.domain.view;

import lotto.common.config.Factory;
import lotto.domain.model.user.Lotto;
import lotto.domain.model.lotto.result.LottoSummary;
import lotto.domain.utils.TestLotto;
import lotto.domain.utils.TestLottoSummary;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @Nested
    @DisplayName("printLottos메서드는")
    class printLottosTest {
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
    }


    @Nested
    @DisplayName("printLottoSummary 메서드는")
    class PrintLottoSummaryTest {
        @DisplayName("로또 당첨 결과를 정리하여 보여준다.")
        @Test
        void printLottoSummary() {
            //given
            LottoSummary testSummary = TestLottoSummary.getTestLottoSummary(1L, 1L, 1L,
                    1L, 1L);
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
}