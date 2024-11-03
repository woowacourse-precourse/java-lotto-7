package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private int[] getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] winningInput = Console.readLine().split(",");
        int[] winningNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            winningNumbers[i] = Integer.parseInt(winningInput[i].trim());
        }
        return winningNumbers;
    }

    private int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private void displayBenefit(int amount, int[] ranks) {
    }

    private void displayResults(int[] ranks) {
    }

}
