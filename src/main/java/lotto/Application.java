package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(winningNumbers);

        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        int purchaseNumber = purchaseAmount / 1000;

        System.out.println(purchaseNumber + "개를 구매했습니다.");
        List<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Integer::compareTo);

            System.out.print("[");
            lottoNumbers.forEach(num -> System.out.print(num + ", "));
            System.out.println("]");

            purchaseLottoNumbers.add(lottoNumbers);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> inputWinningNumbers = Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        System.out.println("보너스 번호를 입력해 주세요.");
        int inputBonusNumber = Integer.parseInt(Console.readLine());

        int[] ranking = new int[6 + 1];
        for (List<Integer> lottoNumbers : purchaseLottoNumbers) {
            Integer matchingNumberCount = lotto.getMatchingNumberCount(lottoNumbers, inputBonusNumber);

            if(matchingNumberCount == 5 && lotto.isBonusNumberMatching(inputBonusNumber)) {
                ranking[0]++;
            }

            ranking[matchingNumberCount]++;
        }

        System.out.println("당첨 통계\n---");
        System.out.println(WinningCriteria.FIFTH_PLACE.getInformation() + ranking[3]);
        System.out.println(WinningCriteria.FOURTH_PLACE.getInformation() + ranking[4]);
        System.out.println(WinningCriteria.THIRD_PLACE.getInformation() + ranking[5]);
        System.out.println(WinningCriteria.SECOND_PLACE.getInformation() + ranking[0]);
        System.out.println(WinningCriteria.FIRST_PLACE.getInformation() + ranking[6]);

        int revenue = 5_000 * ranking[3] + 50_000 * ranking[4] + 1_500_000 * ranking[5] + 30_000_000 * ranking[0]
                + 2_000_000_000 * ranking[6];

        System.out.printf("총 수익률은 %.1f%%입니다.", (float)revenue / purchaseAmount * 100);
        Console.close();
    }
}
