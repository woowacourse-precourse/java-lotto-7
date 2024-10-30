package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.LottoRank;
import lotto.LottoTicket;
import lotto.Result;
import lotto.WinningNumbers;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.io.input.GameInput;
import lotto.io.output.GameOutput;

public class LottoGameController {
    private final GameInput gameInput;
    private final GameOutput gameOutput;

    public LottoGameController(GameInput gameInput, GameOutput gameOutput) {
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
    }

    public void start() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(gameInput.getPurchaseAmount());
        LottoTicket lottoTicket = generateLottoTickets(purchaseAmount.getTicketCount());

        gameOutput.printPurchasedTickets(lottoTicket);

        WinningNumbers winningNumbers = getWinningNumbers();
        Result result = calculateResults(lottoTicket, winningNumbers);

        double yield = purchaseAmount.calculateYield(result.getTotalPrize());
        gameOutput.printResults(result, yield);
    }

    private LottoTicket generateLottoTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(new Lotto(lottoNumbers));
        }
        return new LottoTicket(tickets);
    }

    private WinningNumbers getWinningNumbers() {
        List<Integer> winningNumbers = gameInput.getWinningNumbers();
        BonusNumber bonusNumber = gameInput.getBonusNumber();
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
