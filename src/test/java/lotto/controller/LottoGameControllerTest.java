package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.service.LottoService;
import lotto.service.PrizeCalculator;
import lotto.util.LottoTicketGenerator;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameControllerTest extends NsTest {

    private LottoGameController controller;

    @BeforeEach
    void setUp() {
        LottoService lottoService = new LottoService(new LottoTicketGenerator(), new PrizeCalculator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ErrorView errorView = new ErrorView();
        controller = new LottoGameController(lottoService, inputView, errorView, outputView);
    }

    @Test
    void validFunctionalityTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 입력에 대한 오류 메시지 검증")
    @CsvSource({
            "0, , , '[ERROR] 구입 금액은 양수이며 1,000원 단위여야 합니다.'",
            "1500, , , '[ERROR] 구입 금액은 양수이며 1,000원 단위여야 합니다.'",
            "1001000, , , '[ERROR] 구입 금액이 너무 큽니다. 최대 금액은 1,000,000원입니다.'",
            "2000000, , , '[ERROR] 구입 금액이 너무 큽니다. 최대 금액은 1,000,000원입니다.'",
            "1000j, , , '[ERROR] 입력값은 숫자여야 합니다.'",
            "8000, '0,2,3,4,5,6', 7, '[ERROR] 로또 번호는 1부터 45 사이여야 합니다.'",
            "8000, '1,2,3,4,5,46', 7, '[ERROR] 로또 번호는 1부터 45 사이여야 합니다.'",
            "8000, '1,2,3,4,5', 7, '[ERROR] 로또 번호는 6개의 숫자여야 합니다.'",
            "8000, '1,2,3,4,5,6,7', 7, '[ERROR] 로또 번호는 6개의 숫자여야 합니다.'",
            "8000, '1,1,3,4,5,6', 7, '[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.'",
            "8000, '1,2,3,4,5,6', 46, '[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.'",
            "8000, '1,2,3,4,5,6', 5, '[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.'",
            "8000, '1,2,3,4,5,a', 7, '[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자 형식이어야 합니다.'",
            "'', '', '', '[ERROR] 입력값은 비어 있을 수 없습니다.'"
    })
    void invalidInput_ShouldThrowError(String purchaseAmount, String winningNumbers, String bonusNumber,
                                       String expectedError) {
        assertSimpleTest(() -> {
            runException(purchaseAmount, winningNumbers, bonusNumber);
            assertThat(output()).contains(expectedError);
        });
    }

    @Override
    public void runMain() {
        controller.run();
    }

}
