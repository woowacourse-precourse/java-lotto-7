package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicketFactory;
import lotto.service.LottoEvaluator;
import lotto.service.LottoService;
import lotto.service.PrizeCalculator;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoControllerTest {
    private OutputView outputView = new OutputView();
    private ErrorHandler errorHandler = new ErrorHandler(outputView);
    private InputHandler inputHandler = new InputHandler(errorHandler);
    private LottoShop lottoShop = new LottoShop(new LottoTicketFactory(new LottoNumberGenerator()));
    private ByteArrayOutputStream outputStreamCaptor;
    private LottoService lottoService = new LottoService(lottoShop, new LottoEvaluator(), new PrizeCalculator());

    private InputView inputView = new InputView() {
        @Override
        public String requestLottoPurchaseAmount() {
            return "10000";
        }

        @Override
        public String requestWinningNumbers() {
            return "1,2,3,4,5,6";
        }

        @Override
        public String requestBonusNumber() {
            return "7";
        }
    };

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    void 정상흐름_로또구매와결과출력() {
        //given
        LottoController lottoController = new LottoController(lottoService, inputView, outputView, inputHandler);

        //when
        assertRandomUniqueNumbersInRangeTest(() -> {
            lottoController.run();
            String expectedOutput = "10개를 구매했습니다.\n" +
                    "[8, 21, 23, 41, 42, 43]\n".repeat(10) +
                    "\n당첨 통계\n" +
                    "---\n" +
                    "6개 일치 (2,000,000,000원) - 1개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                    "3개 일치 (5,000원) - 2개\n" +
                    "총 수익률은 150.0%입니다.";
            assertThat(expectedOutput).contains(expectedOutput);
        }, List.of(8, 21, 23, 41, 42, 43));

    }
}