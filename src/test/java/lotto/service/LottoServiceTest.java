package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PrizeTier;
import lotto.util.LottoTicketFactory;
import lotto.util.PrizeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        LottoTicketFactory ticketFactory = new LottoTicketFactory();
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        lottoService = new LottoService(ticketFactory, prizeCalculator);
    }

    @Test
    void generateLottoTickets_ShouldGenerateCorrectNumberOfTickets() {
        // 주어진 금액에 따라 생성된 티켓 개수가 맞는지 확인
        int purchaseAmount = 5000;

        // 로또 티켓 생성
        lottoService.generateLottoTickets(purchaseAmount);
        List<Lotto> purchasedTickets = lottoService.getPurchasedTickets();

        // 티켓 개수와 각 티켓 번호의 개수 확인
        assertThat(purchasedTickets).hasSize(5);
        for (Lotto ticket : purchasedTickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
        }
    }

    @Test
    void setWinningNumbers_ShouldStoreWinningNumbersAndBonus() {
        // 당첨 번호와 보너스 번호가 설정되는지 확인
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // 당첨 번호 설정
        lottoService.setWinningNumbers(winningNumbers, bonusNumber);
        Lotto winningLotto = lottoService.getWinningLotto();

        // 당첨 번호가 정확히 설정되었는지 확인
        assertThat(winningLotto.getNumbers()).isEqualTo(winningNumbers);
    }

    @Test
    void calculateResults_ShouldReturnPrizeResultsForPurchasedTickets() {
        // 구매한 티켓에 대해 당첨 결과가 올바른 개수로 반환되는지 확인
        lottoService.generateLottoTickets(2000);
        lottoService.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> purchasedTickets = lottoService.getPurchasedTickets();

        // 당첨 결과 계산
        List<PrizeTier> prizeResults = lottoService.calculateResults();

        // 당첨 결과 크기가 티켓 개수와 동일한지 확인
        assertThat(prizeResults).hasSize(purchasedTickets.size());
    }

    @Test
    void calculateProfitRate_ShouldReturnCorrectProfitRate() {
        // 수익률 계산이 정상적으로 동작하는지 확인
        lottoService.generateLottoTickets(2000);
        lottoService.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        List<PrizeTier> prizeResults = lottoService.calculateResults();
        int purchaseAmount = 2000;

        // 수익률 계산
        double profitRate = lottoService.calculateProfitRate(prizeResults, purchaseAmount);

        // 수익률이 0 이상인지 확인
        assertThat(profitRate).isGreaterThanOrEqualTo(0);
    }

}
