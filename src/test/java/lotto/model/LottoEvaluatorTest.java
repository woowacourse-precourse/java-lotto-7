package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.dto.LottoEvaluatedStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoEvaluatorTest {

    private LottoTicket lottoTicket;
    private Lotto winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket((List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(7, 8, 9, 10, 11, 12)), // 실패
                new Lotto(List.of(1, 2, 3, 4, 5, 7)) // 2등
        )));

        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
    }

    @DisplayName("로또 티켓의 당첨 상태를 올바른지 확인한다.")
    @Test
    void Given_LottoTicket_When_GetEvaluatedStatus_Then_ReturnCorrectPrizeStatus() {
        LottoEvaluator lottoEvaluator = new LottoEvaluator(lottoTicket, winningNumbers, bonusNumber);
        LottoEvaluatedStatus evaluatedStatus = lottoEvaluator.getEvaluatedStatus();

        HashMap<LottoPrize, Integer> expectedPrizeStatus = new HashMap<>();
        expectedPrizeStatus.put(LottoPrize.FIRST_PRIZE, 1);
        expectedPrizeStatus.put(LottoPrize.SECOND_PRIZE, 1);
        expectedPrizeStatus.put(LottoPrize.THIRD_PRIZE, 0);
        expectedPrizeStatus.put(LottoPrize.FORTH_PRIZE, 0);
        expectedPrizeStatus.put(LottoPrize.FIFTH_PRIZE, 0);
        expectedPrizeStatus.put(LottoPrize.FAIL, 1);

        assertThat(evaluatedStatus.getPrizeStatus()).isEqualTo(expectedPrizeStatus);
    }

    @DisplayName("로또 티켓의 ROI를 정확하게 계산한다.")
    @Test
    void Given_LottoTicket_When_CalculateROI_Then_ReturnCorrectROI() {
        LottoEvaluator evaluator = new LottoEvaluator(lottoTicket, winningNumbers, bonusNumber);
        LottoEvaluatedStatus evaluatedStatus = evaluator.getEvaluatedStatus();

        double expectedROI = (double) (LottoPrize.FIRST_PRIZE.getPrizeAmount()
                + LottoPrize.SECOND_PRIZE.getPrizeAmount()) / (3 * 1000) * 100;
        expectedROI = Math.round(expectedROI * 10) / 10.0;

        assertThat(evaluatedStatus.getReturnOnInvestment()).isEqualTo(expectedROI);
    }

    @DisplayName("로또 번호와 보너스 번호 일치 여부를 정확하게 확인한다.")
    @Test
    void Given_LottoNumbersAndBonus_When_EvaluateTicket_Then_CorrectlyIdentifyPrizes() {
        LottoEvaluator lottoEvaluator = new LottoEvaluator(lottoTicket, winningNumbers, bonusNumber);
        HashMap<LottoPrize, Integer> prizeStatus = lottoEvaluator.getEvaluatedStatus().getPrizeStatus();

        assertThat(prizeStatus.get(LottoPrize.FIRST_PRIZE)).isEqualTo(1);
        assertThat(prizeStatus.get(LottoPrize.SECOND_PRIZE)).isEqualTo(1);
        assertThat(prizeStatus.get(LottoPrize.FAIL)).isEqualTo(1);
    }

}
