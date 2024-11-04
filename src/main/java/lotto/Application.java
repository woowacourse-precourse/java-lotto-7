package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();
            LottoGame lottoGame = new LottoGame(purchaseAmount);
            lottoGame.printPurchasedLottos();
            WinNumbers winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();
            lottoGame.calculateResults(winningNumbers, bonusNumber);
            lottoGame.printResults();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return amount;
    }

    private static WinNumbers getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbers = Console.readLine().split(",");
        return new WinNumbers(numbers);
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
