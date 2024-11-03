package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.service.LottoService;
import lotto.service.StatisticsService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        StatisticsService statisticsService = new StatisticsService();

        String purchaseAmount;
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();

        int purchaseAmountInt = validatePurchaseAmount(purchaseAmount);

        LottoTicket lottoTicket = lottoService.generateLottos(purchaseAmountInt);
        System.out.println("\n" + lottoTicket.getLottos().size() + "개를 구매했습니다.");
        lottoTicket.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));

        String inputWinningNumbers;
        System.out.println("\n당첨 번호를 입력해 주세요.");
        inputWinningNumbers = Console.readLine();

        List<String> winningNumbers = List.of(inputWinningNumbers.split(","));
        List<Integer> winningNumbersInteger = stringListToIntegerList(winningNumbers);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        Map<LottoResult, Integer> lottoResultCount = lottoService.calculateStatisticsLottoResult(lottoTicket,
                winningNumbersInteger,
                bonusNumber);
        printStatistics(lottoResultCount);

        double rateEarning = statisticsService.calculateRateEarning(lottoResultCount, purchaseAmountInt);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateEarning);
    }

    public static int calculateTotalPrizeMoney(Map<LottoResult, Integer> lottoResultCount) {
        int prizeMoneyAmount = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            prizeMoneyAmount += lottoResult.getPrizeMoney() * lottoResultCount.get(lottoResult);
        }
        return prizeMoneyAmount;
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

    public static List<Integer> stringListToIntegerList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList) {
            intList.add(Integer.parseInt(s));
        }
        return intList;
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
