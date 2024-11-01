package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
    @DisplayName("당첨 번호와 보너스 번호 설정 확인")
    void setWinningNumbers_ShouldStoreWinningNumbersAndBonus() {
        lottoService.setWinningNumbers(WINNING_NUMBERS, BONUS_NUMBER);
        Lotto winningLotto = lottoService.getWinningTicket();

        assertThat(winningLotto.getNumbers()).isEqualTo(WINNING_NUMBERS);
    }

    @Test
    @DisplayName("구매한 티켓의 당첨 결과 반환 확인")
    void calculateResults_ShouldReturnPrizeResultsForPurchasedTickets() {
        lottoService.generateLottoTickets(2000);
        lottoService.setWinningNumbers(WINNING_NUMBERS, BONUS_NUMBER);
        List<Lotto> purchasedTickets = lottoService.getLottoTickets();

        List<PrizeTier> prizeResults = lottoService.calculateResults();

        assertThat(prizeResults).hasSize(purchasedTickets.size());
    }

    @Test
    @DisplayName("올바른 수익률 계산 확인")
    void calculateProfitRate_ShouldReturnCorrectProfitRate() {
        lottoService.generateLottoTickets(2000);
        lottoService.setWinningNumbers(WINNING_NUMBERS, BONUS_NUMBER);
        List<PrizeTier> prizeResults = lottoService.calculateResults();
        int purchaseAmount = 2000;

        double profitRate = lottoService.calculateProfitRate(prizeResults, purchaseAmount);

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
