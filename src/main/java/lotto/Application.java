package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.EnumMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        getMoney();
        purchaseLottos(0);
        getWinningLotto();
        getBonusNumber();
        checkResults(null, null, 0, 0);
        displayResults(null);
        displayProfit(null, 0);
    }

    private static int getMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            if (money < 1000 || money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 금액을 입력하였습니다.");
        }
    }

    private static List<Lotto> purchaseLottos(int ticketCount) {
        return null;
    }

    private static Lotto getWinningLotto() {
        return null;
    }

    private static int getBonusNumber() {
        return 0;
    }

    private static void checkResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber, int moneySpent) {
    }

    private static void displayResults(Map<Rank, Integer> matchCounts) {
    }

    private static void displayProfit(Map<Rank, Integer> matchCounts, int moneySpent) {
    }
}