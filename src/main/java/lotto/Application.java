package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력 : 금액 , 당첨 번호, 보너스 번호
        int lotoQuantity;
        long totalPrize = 0;
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

        Map<Prize, Integer> prizeCount = new HashMap<>();
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }

        for (List<Integer> lotto : lottos) {
            int matchCount = prizeCheck.getMatchCount(lotto);
            boolean bonusMatched = prizeCheck.getBonusNumCount(lotto);
            for (Prize prize : Prize.values()) {
                if (prize.getMatchCount() == matchCount && prize.isBonusMatch() == bonusMatched) {
                    prizeCount.put(prize, prizeCount.get(prize) + 1);
                    totalPrize += prize.getPrizeAmount();
                    break;
                }
            }
        }

        printPrizeResult(prizeCount);
        long purchaseAmount = lotoQuantity * 1000L;
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static void printPrizeResult(Map<Prize, Integer> prizeCount) {
        for (Prize prize : Prize.values()) {
            if (prize.getPrizeAmount() > 0) { // 당첨된 등수만 출력
                String bonusMessage = "";
                if (prize.isBonusMatch()) {
                    bonusMessage = ", 보너스 볼 일치";
                }
                System.out.printf(
                        "%d개 일치%s (%s원) - %d개%n",
                        prize.getMatchCount(),
                        bonusMessage,
                        String.format("%,d", prize.getPrizeAmount()),
                        prizeCount.get(prize)
                );
            }
        }
    }
}


