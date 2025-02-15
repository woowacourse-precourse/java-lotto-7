package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.contoller.LottoController;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.service.ProfitCalculatorService;
import lotto.service.ResultStatisticsService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class ControllerTest {
    private LottoController lottoController;
    private ByteArrayOutputStream output;
    @BeforeEach
    void setUp() {
        lottoController = new LottoController(
                ResultStatisticsService.getInstance(),
                ProfitCalculatorService.getInstance()
        );
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void clearInputBuffer() {
        Console.close();
    }
    @DisplayName("정상적인 구매 금액 입력")
    @Test
    void getPurchaseAmount_정상() {
        // given
        String input = "8000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        int amount = lottoController.getPurchaseAmount();

        //then
        Assertions.assertThat(amount).isEqualTo(8000);
    }

    @DisplayName("잘못된 구매 금액 입력 후 정상 입력")
    @Test
    void getPurchaseAmount_예외_처리() {
        // given
        String input = "1000a\n8000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

         //when
        int amount = lottoController.getPurchaseAmount();
        String printedOutput = output.toString();

         //then
        Assertions.assertThat(printedOutput).contains("[ERROR]");
        Assertions.assertThat(amount).isEqualTo(8000);
    }

    @DisplayName("당첨 번호 정상 입력")
    @Test
    void getWinningLotto_정상() {
        // given
        String input = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        WinningLotto winningLotto = lottoController.getWinningLotto();

        // then
        Assertions.assertThat(winningLotto.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("잘못된 당첨 번호 입력 후 정상 입력")
    @Test
    void getWinningLotto_예외_처리() {
        // given
        String input = "1,2,3,4,5\n1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        WinningLotto winningLotto = lottoController.getWinningLotto();
        String printedOutput = output.toString();

        // then
        Assertions.assertThat(printedOutput).contains("[ERROR]");
        Assertions.assertThat(winningLotto.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호 정상 입력")
    @Test
    void getBonusNumber_정상() {
        // given
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        WinningLotto result = lottoController.getBonusNumber(winningLotto);

        // then
        Assertions.assertThat(result.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("잘못된 보너스 번호 입력 후 정상 입력")
    @Test
    void getBonusNumber_예외_처리() {
        // given
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "1\n7\n";  // 1은 이미 당첨 번호에 있어서 에러
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        WinningLotto result = lottoController.getBonusNumber(winningLotto);
        String printedOutput = output.toString();

        // then
        Assertions.assertThat(printedOutput).contains("[ERROR]");
        Assertions.assertThat(result.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("로또 구매 결과 출력")
    @Test
    void createLottoTickets_출력_테스트() {
        // when
        List<Lotto> tickets = lottoController.createLottoTickets(3);
        String printedOutput = output.toString();

        // then
        Assertions.assertThat(printedOutput)
                .contains("3개를 구매했습니다.");
        Assertions.assertThat(tickets).hasSize(3);
    }

    @DisplayName("당첨 통계 출력")
    @Test
    void showGameResults_출력_테스트() {
        // given
        int purchaseAmount = 8000;
        List<Lotto> purchasedLotto = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLotto.setBonusNumber(7);

        // when
        lottoController.showGameResults(purchaseAmount, purchasedLotto, winningLotto);
        String printedOutput = output.toString();

        // then
        Assertions.assertThat(printedOutput)
                .contains("당첨 통계")
                .contains("6개 일치");
    }
}