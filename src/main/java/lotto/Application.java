package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        LottoHandler lottoHandler = new LottoHandler();
        OutputHandler outputHandler = new OutputHandler();

        int purchaseAmount = inputHandler.getPurchaseAmount();
        lottoHandler.generateTickets(purchaseAmount);

        List<Lotto> purchasedTickets = lottoHandler.getPurchasedTickets();
        outputHandler.printTickets(purchasedTickets);

        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber();

        LottoResult result = lottoHandler.calculateResults(winningNumbers, bonusNumber);
        outputHandler.printResults(result);
    }
}
