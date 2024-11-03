package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;

public class Application {
    public static void main(String[] args) {

        String purchaseAmount;
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();

        int purchaseAmountInt = validatePurchaseAmount(purchaseAmount);

        LottoTicket lottoTicket = new LottoTicket();
        System.out.println();
        System.out.println(purchaseAmountInt / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < purchaseAmountInt / 1000; i++) {
            Lotto lotto = new Lotto(pickLottoNumber());
            lotto.sortAscendingInteger();
            lottoTicket.addLotto(lotto);

            System.out.println(lotto.getNumbers());
        }

        String inputWinningNumbers;
        System.out.println("\n당첨 번호를 입력해 주세요.");
        inputWinningNumbers = Console.readLine();

        List<String> winningNumbers = List.of(inputWinningNumbers.split(","));
        List<Integer> winningNumbersInteger = stringListToIntegerList(winningNumbers);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        Map<LottoResult, Integer> lottoResultCount = calculateStatisticsLottoResult(lottoTicket, winningNumbersInteger,
                bonusNumber);
        printStatistics(lottoResultCount);

        int prizeMoneyAmount = calculateTotalPrizeMoney(lottoResultCount);
        double rateEarning = (double) prizeMoneyAmount / purchaseAmountInt * 100;
        rateEarning = Math.round(rateEarning * 100) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateEarning);
    }

    public static int calculateTotalPrizeMoney(Map<LottoResult, Integer> lottoResultCount) {
        int prizeMoneyAmount = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            prizeMoneyAmount += lottoResult.getPrizeMoney() * lottoResultCount.get(lottoResult);
        }
        return prizeMoneyAmount;
    }

    public static Map<LottoResult, Integer> calculateStatisticsLottoResult(LottoTicket lottoTicket,
                                                                           List<Integer> winningNumbers,
                                                                           int bonusNumber) {
        Map<LottoResult, Integer> lottoResultCount = new HashMap<>();

        for (LottoResult lottoResult : LottoResult.values()) {
            lottoResultCount.put(lottoResult, 0);
        }

        for (Lotto lotto : lottoTicket.getLottos()) {
            int matchCount = countMatches(lotto, winningNumbers);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            LottoResult lottoResult = LottoResult.getLottoResult(matchCount, hasBonus);

            if (lottoResult != null) {
                lottoResultCount.put(lottoResult, lottoResultCount.get(lottoResult) + 1);
            }
        }

        return lottoResultCount;
    }

    public static void printStatistics(Map<LottoResult, Integer> lottoResultCount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult == LottoResult.FIVE_BONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                        lottoResult.getMatchCount(), lottoResult.getPrizeMoney(),
                        lottoResultCount.get(lottoResult));
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개%n", lottoResult.getMatchCount(), lottoResult.getPrizeMoney(),
                    lottoResultCount.get(lottoResult));
        }
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
