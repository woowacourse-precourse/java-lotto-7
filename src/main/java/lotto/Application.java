package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력 : 금액 , 당첨 번호, 보너스 번호
        int lotoQuantity;
        ArrayList<List<Integer>> lottos = new ArrayList<>();

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputMoney = Console.readLine();
                System.out.println(inputMoney);
                Purchase moneyPurchas = new Purchase(inputMoney);
                lotoQuantity = moneyPurchas.getLotoCount();
                break;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < lotoQuantity; i++) {
            Lotto lotto = new Lotto(Randoms.
                    pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto.getLotto());
            System.out.println(lotto.getLotto());
        }
        PrizeCheck prizeCheck = new PrizeCheck();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String prizeNum = Console.readLine();
                prizeCheck.checkAndChangePrizeNum(prizeNum);
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNum = Console.readLine();
                prizeCheck.checkAndChangeBonusNum(bonusNum);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}



