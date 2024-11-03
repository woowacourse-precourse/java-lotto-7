package lotto;

public class LottoService {
    private final Selling selling = new Selling();
    private final Benefit benefit = new Benefit();

    public void run() {
        try {
            int amount = getPurchaseAmount();
            Lotto[] userLottos = selling.purchaseLottos(amount);

            int[] winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();
            Winning winning = new Winning(winningNumbers, bonusNumber);

            int[] ranks = calculateResults(userLottos, winning);
            displayResults(ranks);
            displayBenefit(amount, ranks);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int[] calculateResults(Lotto[] userLottos, Winning winning) {
    }

    private int getBonusNumber() {
    }

    private int[] getWinningNumbers() {
    }

    private int getPurchaseAmount() {
    }

    private void displayBenefit(int amount, int[] ranks) {
    }

    private void displayResults(int[] ranks) {
    }

}
