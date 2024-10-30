package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.util.RandomNumGenerator;

public class LottoService {

    private Money money;
    private LottoTicket lottoTicket;
    private WinningNumbers winningNumbers;

    public void createMoney(int budget) {
        money = new Money(budget);
    }

    public int getLottoCount() {
        return money.getTicketCount();
    }

    public List<String> createLottoTicket() {
        int ticketCount = money.getTicketCount();
        lottoTicket = new LottoTicket(ticketCount, new RandomNumGenerator());
        return lottoTicket.getPrintFormNumbers();
    }

    public void createWinningNumbers(List<Integer> numbers) {
        winningNumbers = new WinningNumbers(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        winningNumbers.setBonusNumber(bonusNumber);
    }

    public Map<Rank, Integer> getResult() {
        return lottoTicket.getResult(
            winningNumbers.getWinningNumbers(),
            winningNumbers.getBonusNumber()
        );
    }

    public String getRateOfReturn(Map<Rank, Integer> result) {
        return money.getRateOfReturn(result);
    }
}
