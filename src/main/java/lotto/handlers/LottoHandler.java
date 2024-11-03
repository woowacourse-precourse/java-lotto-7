package lotto.handlers;

import lotto.models.Lotto;
import lotto.models.LottoResults;
import lotto.models.constants.LottoValues;
import lotto.ui.OutputView;
import lotto.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class LottoHandler {
    private final OutputView outputView;
    private ArrayList<Lotto> tickets;

    public LottoHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public void generateTickets(int purchaseAmount) {
        int lottoCount = purchaseAmount / LottoValues.TICKET_PRICE.getValue();
        outputView.printPurchasedMessage(lottoCount);
        this.tickets = new ArrayList<>(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = Randomizer.getRandomLottoNumbers();
            Lotto newLotto = new Lotto(randomNumbers);
            outputView.printIntegerList(randomNumbers);
            this.tickets.add(newLotto);
        }
    }

    public void findMatches(List<Integer> winningNumbers, int bonusNumber, LottoResults lottoResults) {
        for (Lotto ticket : this.tickets) {
            int matches = ticket.getMatches(winningNumbers, bonusNumber);
            lottoResults.recordMatch(matches);
        }
    }
}
