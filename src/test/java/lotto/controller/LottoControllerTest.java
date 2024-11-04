package lotto.controller;

import lotto.TestConstants;
import lotto.service.TestLottoServiceImpl;
import lotto.view.TestInputView;
import lotto.view.TestOutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {
    private static final List<Integer> VALID_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final String TEST_PURCHASE_AMOUNT = "1000";
    private static final String TEST_WINNING_NUMBERS = "1,2,3,4,5,6";
    private static final String TEST_BONUS_NUMBER = "7";

    private LottoController lottoController;
    private TestInputView testInputView;
    private TestOutputView testOutputView;

    @BeforeEach
    void setUp() {
        TestLottoServiceImpl testLottoService = new TestLottoServiceImpl(VALID_LOTTO_NUMBERS, TestConstants.VALID_WINNING_NUMBERS, TestConstants.VALID_BONUS_NUMBER);
        testInputView = new TestInputView(List.of(TEST_PURCHASE_AMOUNT, TEST_WINNING_NUMBERS, TEST_BONUS_NUMBER));
        testOutputView = new TestOutputView();
        lottoController = new LottoController(testLottoService, testInputView, testOutputView);
    }

    @DisplayName("LottoController 전체 실행 테스트")
    @Test
    void testRun() {
        lottoController.run();

        assertThat(testInputView.getPrintedMessages()).containsExactly(
                "구입 금액을 입력해 주세요.",
                "당첨 번호를 입력해 주세요.",
                "보너스 번호를 입력해 주세요."
        );

        assertThat(testOutputView.getPrintedMessages()).contains(
                "1개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 200000000.0%입니다."
        );
    }
}