package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String purchaseAmount;
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();

        int purchaseAmountInt = validatePurchaseAmount(purchaseAmount);

        List<Lotto> lottos = new ArrayList<>();
        System.out.println();
        System.out.println(purchaseAmountInt / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < purchaseAmountInt / 1000; i++) {
            Lotto lotto = new Lotto(pickLottoNumber());
            lotto.sortAscendingInteger();
            lottos.add(lotto);

            System.out.println(lotto.getNumbers());
        }

        String inputWinningNumbers;
        System.out.println("\n당첨 번호를 입력해 주세요.");
        inputWinningNumbers = Console.readLine();

        List<String> winningNumbers = List.of(inputWinningNumbers.split(","));
        List<Integer> winningNumbersInteger = stringListToIntegerList(winningNumbers);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        
    }

    public static int countMatches(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static List<Integer> stringListToIntegerList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList) {
            intList.add(Integer.parseInt(s));
        }
        return intList;
    }

    public static List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static int validatePurchaseAmount(String purchaseAmount) {
        int purchaseAmountInt;
        try {
            purchaseAmountInt = Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수여야합니다");
        }
        if (purchaseAmountInt <= 0 || purchaseAmountInt % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야합니다.");
        }

        return purchaseAmountInt;
    }
}
