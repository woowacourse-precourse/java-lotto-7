package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NO = 1;
    private static final int MAX_LOTTO_NO = 45;
    private static final int LOTTO_COUNT = 6;

    public static void main(String[] args) {
        int budget;
        while (true) {
            try {
                budget = readBudget();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        final List<Lotto> lottos = new ArrayList<>();
        for (int i = budget / 1000; i != 0; i--) {
            lottos.add(new Lotto(pickUniqueNumbersInRange(MIN_LOTTO_NO, MAX_LOTTO_NO, LOTTO_COUNT)));
        }
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (final Lotto lotto : lottos) {
            System.out.println('[' + lotto.toString() + ']');
        }
        System.out.println("3개 일치 (5,000원) - 1개");
        System.out.println("4개 일치 (50,000원) - 0개");
        System.out.println("5개 일치 (1,500,000원) - 0개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        System.out.println("6개 일치 (2,000,000,000원) - 0개");
        System.out.println("총 수익률은 62.5%입니다.");
    }

    private static int readBudget() throws IllegalArgumentException {
        int budget;
        try {
            budget = Integer.parseInt(readLine());
            assert budget >= 0;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0 이상의 자연수여야 합니다.");
        }
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        return budget;
    }
}
