package lotto;

import java.util.*;

public class Application {
    private static int getCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        try {
            int cost = Integer.parseInt(input);
            return cost;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    private static void vaildateCost(int cost) {
        if (cost <= 0 || cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 자연수만 입력할 수 있습니다.");
        }
    }

    private static int getAmount() {
        while (true) {
            try {
                int cost = getCost();
                vaildateCost(cost);
                int amount = cost / 1000;
                return amount;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        int amount = getAmount();
        System.out.println();

    }
}
