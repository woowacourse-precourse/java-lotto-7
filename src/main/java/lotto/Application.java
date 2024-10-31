package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Map;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        User user = inputNewUser();
        printPurchaseStatus(user.getLottos());

        Committee committee = new Committee();
        committee.checkLottos(user);

        printPrizes(user.getPrizes(), user.getReturnRate());
    }

    private static User inputNewUser() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return new User(Console.readLine());
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return inputNewUser();
        }
    }

    public static void printPurchaseStatus(ArrayList<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printPrizes(Map<Prize, Integer> prizes, double returnRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (int i = Prize.values().length - 1; i >= 0; i--) {
            Prize prize = Prize.values()[i];
            if (prize != Prize.FAIL) {
                System.out.println(prize.getDescription() + " - " + prizes.get(prize) + "개");
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}
