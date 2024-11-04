package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        Money money = null;
        while (money == null || game.getLottoCount() == 0) {
            System.out.println("구입금액을 입력해 주세요.");
            String moneyInput = Console.readLine();
            try {
                money = new Money(moneyInput);
                game.purchaseLotto(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        game.assignRandomNumberToLotto();
        System.out.println();
        game.prettyPrintPurchasedLottos();
        System.out.println();

        while (game.getWinningLotto() == null) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbersInput = Console.readLine();
            try {
                game.assignWinningLotto(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (game.getBonusNumber() == 0) {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();
            try {
                game.assignBonusNumber(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        // TODO: show statistics
    }
}
