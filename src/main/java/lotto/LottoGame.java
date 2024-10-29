package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        int purchaseAmount = inputView.getPurchaseAmount();
        LottoTicket lottoTicket = generateLottoTickets(purchaseAmount);

        outputView.printPurchasedTickets(lottoTicket);

        WinningNumbers winningNumbers = getWinningNumbers();
        Result result = calculateResults(lottoTicket, winningNumbers);

        outputView.printResults(result, purchaseAmount);
    }

    private LottoTicket generateLottoTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / 1000;
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(new Lotto(lottoNumbers)); // List<Integer>로 전달
        }
        return new LottoTicket(tickets);
    }

    private WinningNumbers getWinningNumbers() {
        List<LottoNumber> winningNumbers = inputView.getWinningNumbers();
        LottoNumber bonusNumber = inputView.getBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private Result calculateResults(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        Result result = new Result();
        for (Lotto lotto : lottoTicket.getTickets()) {
            int matchCount = lotto.matchCount(winningNumbers.getWinningNumbers());
            boolean matchBonus = lotto.containsBonus(winningNumbers.getBonusNumber());
            LottoRank rank = LottoRank.findByMatchCountAndBonus(matchCount, matchBonus);
            result.addMatchResult(rank);
        }
        return result;
    }
}
