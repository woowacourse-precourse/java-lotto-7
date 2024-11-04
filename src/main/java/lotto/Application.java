package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Lottery lottery = new Lottery();

        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        lottery.issue(Integer.parseInt(purchaseAmount));

        System.out.println("당첨 번호를 입력해 주세요.");
        String prizeNum = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        lottery.prize(prizeNum, bonusNum, purchaseAmount);
    }
}
