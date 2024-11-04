package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("로또 발매기를 시작합니다.");

        InputHandler inputHandler = new InputHandler();
        int purchaseAmount = inputHandler.getPurchaseAmount();
        int ticketCount = purchaseAmount / 1000;

        System.out.println(ticketCount + "개의 로또를 구매했습니다.");

        LottoManager lottoManager = new LottoManager();
        List<Lotto> lottos = lottoManager.generateLottos(ticketCount);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber();

        Statistics statistics = new Statistics();
        statistics.calculateAndDisplay(lottos, winningNumbers, bonusNumber, purchaseAmount);
    }
}
