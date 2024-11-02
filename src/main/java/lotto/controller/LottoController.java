package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.model.Cost;
import lotto.model.Lotto;

public class LottoController {

    private Lotto lotto;
    private int cost;
    private int bonusNumber;
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");

        cost = requestCostInput();

        int purchaseCount = cost / 1000;

        System.out.println();

        System.out.println(purchaseCount + "개를 구매했습니다.");

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
            System.out.println(lottoNumbers.get(i));
        }

        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");

        lotto = requestLottoNumberInput();

        System.out.println();

        System.out.println("보너스 번호를 입력해주세요.");

        bonusNumber = requestBonusNumberInput();

        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");

        int threeMatched = 0;
        int fourMatched = 0;
        int fiveMatched = 0;
        int bonusMatched = 0;
        int allMatched = 0;

        for (List<Integer> lottoNumber : lottoNumbers) {
            int lottoCount = 0;
            boolean isBonusMatched = lottoNumber.contains(bonusNumber);

            for (int number : lotto.getNumbers()) {
                if (lottoNumber.contains(number)) {
                    lottoCount++;
                }
            }

            if (lottoCount == 6) {
                allMatched++;
                continue;
            }
            if (lottoCount == 5 && isBonusMatched) {
                bonusMatched++;
                continue;
            }
            if (lottoCount == 5) {
                fiveMatched++;
                continue;
            }
            if (lottoCount == 4) {
                fourMatched++;
                continue;
            }
            if (lottoCount == 3) {
                threeMatched++;
            }
        }

        System.out.println("3개 일치 (5,000원) - " + threeMatched + "개");
        System.out.println("4개 일치 (50,000원) - " + fourMatched + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatched + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonusMatched + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + allMatched + "개");

        int totalWinnings = (5000 * threeMatched) + (50000 * fourMatched) +
                (1500000 * fiveMatched) + (30000000 * bonusMatched) +
                (2000000000 * allMatched);

        double earningRatio = ((double) totalWinnings / cost) * 100;
        String formatEarningRatio = String.format("%,.1f", earningRatio);
        System.out.println("총 수익률은 " + formatEarningRatio + "%입니다.");

    }

    private int requestBonusNumberInput() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine().trim());

            if (String.valueOf(bonusNumber).isBlank()) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");
            }

            if (bonusNumber < 0) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 음수를 입력할 수 없습니다.");
            }

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해주세요.");
            }

            if (lotto.getNumbers().contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
            }
            return bonusNumber;

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
            return requestBonusNumberInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBonusNumberInput();
        }
    }

    private Lotto requestLottoNumberInput() {
        try {
            return new Lotto(Arrays.stream(Console.readLine().trim().split(","))
                    .map(Integer::parseInt)
                    .toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestLottoNumberInput();
        }
    }

    private int requestCostInput() {
        try {
            return Cost.from(Integer.parseInt(Console.readLine().trim())).getCost();

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 금액은 숫자만 입력할 수 있습니다.");
            return requestCostInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCostInput();
        }
    }
}
