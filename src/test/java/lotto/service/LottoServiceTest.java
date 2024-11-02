package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import lotto.constants.LottoConstants;
import lotto.model.Lotto;
import lotto.model.PrizeTier;
import lotto.util.LottoTicketGenerator;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService;
    private static final int TICKET_PRICE = LottoConstants.LOTTO_PRICE;
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;

    @BeforeEach
    void setUp() {
        LottoTicketGenerator ticketFactory = new LottoTicketGenerator();
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        lottoService = new LottoService(ticketFactory, prizeCalculator);
    }

    @Test
    @DisplayName("구매 금액에 따른 올바른 로또 티켓 개수 생성")
    void generateLottoTickets_ShouldGenerateCorrectNumberOfTickets() {
        int purchaseAmount = 5000;

        lottoService.generateLottoTickets(purchaseAmount);
        List<Lotto> purchasedTickets = lottoService.getLottoTickets();

        assertThat(purchasedTickets).hasSize(purchaseAmount / TICKET_PRICE);
        for (Lotto ticket : purchasedTickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
        }
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호 설정 후 결과 검증")
    void setWinningNumbers_ShouldCalculateResultsCorrectly() {

        lottoService.generateLottoTickets(2000);

        // 당첨 번호 및 보너스 번호 설정
        lottoService.setWinningNumbers(WINNING_NUMBERS, BONUS_NUMBER);

        // 당첨 결과를 계산하여 당첨 번호가 올바르게 설정되었는지 검증
        Map<PrizeTier, Long> prizeResults = lottoService.calculateResults();
        assertThat(prizeResults).isNotEmpty();
    }

    @Test
    @DisplayName("구매한 티켓의 당첨 결과 반환 확인")
    void calculateResults_ShouldReturnPrizeResultsForPurchasedTickets() {
        lottoService.generateLottoTickets(2000);
        lottoService.setWinningNumbers(WINNING_NUMBERS, BONUS_NUMBER);

        Map<PrizeTier, Long> prizeResults = lottoService.calculateResults();

        assertThat(prizeResults.values().stream().mapToLong(Long::longValue).sum())
                .isEqualTo(lottoService.getLottoTickets().size());
    }

    @Test
    @DisplayName("올바른 수익률 계산 확인")
    void calculateProfitRate_ShouldReturnCorrectProfitRate() {
        lottoService.generateLottoTickets(2000);
        lottoService.setWinningNumbers(WINNING_NUMBERS, BONUS_NUMBER);
        int purchaseAmount = 2000;

        double profitRate = lottoService.calculateProfitRate(purchaseAmount);

        assertThat(profitRate).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("중복된 당첨 번호 설정 시 예외 발생")
    void setWinningNumbers_ShouldThrowException_WhenDuplicateWinningNumbers() {
        List<Integer> duplicateWinningNumbers = List.of(1, 2, 3, 4, 5, 5); // 중복 번호 포함

        assertThatThrownBy(() -> lottoService.setWinningNumbers(duplicateWinningNumbers, BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATE_INVALID.getMessage());
    }

}
