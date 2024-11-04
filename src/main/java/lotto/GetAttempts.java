package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GetAttempts {
    public static int validateBetAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자를 입력했습니다.");
        }
        int betAmount = Integer.parseInt(input);
        if (betAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 베팅 금액이 1000원 미만입니다");
        }
        if (betAmount % 1000 != 0) {
            throw new IllegalArgumentException("베팅 금액이 1000원 단위가 아닙니다");
        }
        return betAmount;
    }

    public static int getAttempts(int betAmount) {
        int attempts = betAmount / 1000;
        System.out.println(attempts + "개를 구매했습니다.");
        return attempts;
    }

    public static List<List<Integer>> printEntries(int attempts) {
        List<List<Integer>> entryLists = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            List<Integer> entries = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            entries.sort(Comparator.naturalOrder());
            entryLists.add(entries);
        }
        for (int j = 0; j < attempts; j++) {
            System.out.println(entryLists.get(j));
        }
        return entryLists;
    }
}
