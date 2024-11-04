package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력 : 금액 , 당첨 번호, 보너스 번호
        int lotoQuantity;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputMoney = Console.readLine();
                System.out.println(inputMoney);
                MoneyPurchase moneyPurchas = new MoneyPurchase(inputMoney);
                lotoQuantity= moneyPurchas.getLotoCount();
                break;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}



