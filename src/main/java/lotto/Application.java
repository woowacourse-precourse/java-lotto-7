package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("1구입금액을 입력해 주세요.");
        int purchaseInt;
        while (true) {
            String purchase = Console.readLine();
            if (lotto.Lotto.validatePurchase(purchase)) {
                purchaseInt = Integer.parseInt(purchase);
                break;
            }
        }

        System.out.println("2당첨 번호를 입력해 주세요.");
        String winningNumber[];
        while (true) {
            String winningNum = Console.readLine();
            winningNumber = winningNum.split(",");
            if (lotto.Lotto.validateWinningNumber(winningNumber)) {
                break;
            }
        }

        System.out.println("3보너스 번호를 입력해 주세요.");
        while (true) {
            String bonusNum = Console.readLine();
            if (lotto.Lotto.validateBonus(winningNumber, bonusNum)) {
                Integer bonusNumInt = Integer.parseInt(bonusNum);
                break;
            }
        }
//        System.out.println(purchaseInt / 1000);
        lotto.Lotto.purchaseLotto(purchaseInt / 1000);

    }


}
