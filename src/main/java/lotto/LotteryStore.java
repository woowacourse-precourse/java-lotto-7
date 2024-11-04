package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LotteryStore {
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    List<Lotto> purchase() {
        int numberOfPurchases = inputSpending();
        System.out.println();

        for(int i = 0; i < numberOfPurchases; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumbers);

            purchasedLottos.add(lotto);
        }

        displayPurchasedLottos();

        return purchasedLottos;
    }

    private static int inputSpending() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int purchaseAmount = Integer.parseInt(input);

            validatePuchaseAmount(purchaseAmount);
            return purchaseAmount / 1000;

        } catch(NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해 주세요.");

            return inputSpending();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return inputSpending();
        }
    }

    private static void validatePuchaseAmount(int puchaseAmount) {

        if (puchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요");
        }

        if (puchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다");
        }
    }

    private void displayPurchasedLottos() {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }


}
