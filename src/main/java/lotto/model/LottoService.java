package lotto.model;

import java.util.List;
import java.util.Map;
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

    public void createWinningNumbers(List<Integer> numbers, int bonusNumber) {
        winningNumbers = new WinningNumbers(numbers, bonusNumber);
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
