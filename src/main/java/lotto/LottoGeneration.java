package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGeneration {
    public static int inputPurchaseAmount() {
        while (true) {
            String input = Console.readLine().trim();
            int amount = parseInputToInteger(input);
            if (amount != -1) {
                return amount;
            }
        }
    }

    private static int parseInputToInteger(String input) {
        try {
            validatePurchaseAmount(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    private static void validatePurchaseAmount(String input) {
        if (!Util.isInteger(input)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000 단위 정수만 입력되야 합니다.");
        }

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    public static int extractQuantity(int amount) {
        return amount / 1000;
    }

    public static List<Lotto> issueLotto(int quantity) {
        List<Lotto> lottoSets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoSets.add(lotto);
        }
        return lottoSets;
    }

    public static void printLotto(List<Lotto> lottoSets, int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
        for (Lotto lotto : lottoSets) {
            lotto.printNumbers();
        }
    }
}
