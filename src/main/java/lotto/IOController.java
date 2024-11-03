package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class IOController {

    Validator validator = new Validator();
    public static final String COMMA = ",";

    public Integer inputPurchaseAmount() {
        Integer purchaseAmount = null;
        while (purchaseAmount == null) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountInput = Console.readLine();
            try {
                validator.purchaseAmountValidate(purchaseAmountInput);
                purchaseAmount = Integer.parseInt(purchaseAmountInput);
            } catch (IllegalArgumentException ignored) {
            }
        }
        return purchaseAmount;
    }

    public void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = null;
        while (winningNumbers == null) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbersString = Console.readLine();
            List<String> winningNumbersStringList = Arrays.stream(winningNumbersString.split(COMMA))
                    .map(String::trim).toList();
            try {
                validator.winningNumberValidate(winningNumbersStringList);
                winningNumbers = winningNumbersStringList.stream().map(Integer::parseInt).toList();
            } catch (IllegalArgumentException ignored) {
            }
        }
        return winningNumbers;
    }

    public Integer inputBonusNumber(List<Integer> winningNumbers) {
        Integer bonusNumber = null;
        while (bonusNumber == null) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();
            try {
                validator.bonusNumberValidate(winningNumbers, bonusNumberInput);
                bonusNumber = Integer.parseInt(bonusNumberInput);
            } catch (IllegalArgumentException ignored) {
            }
        }
        return bonusNumber;
    }

    public void printWinningStatistics(LottoStatistic lottoStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---");

        printRankStatistics("3개 일치", LottoPrize.FIFTH_PRIZE.getPrizeAmount(), lottoStatistic.getCount3Match());
        printRankStatistics("4개 일치", LottoPrize.FOURTH_PRIZE.getPrizeAmount(), lottoStatistic.getCount4Match());
        printRankStatistics("5개 일치", LottoPrize.THIRD_PRIZE.getPrizeAmount(), lottoStatistic.getCount5Match());
        printRankStatistics("5개 일치, 보너스 볼 일치", LottoPrize.SECOND_PRIZE.getPrizeAmount(),
                lottoStatistic.getCount5MatchWithBonus());
        printRankStatistics("6개 일치", LottoPrize.FIRST_PRIZE.getPrizeAmount(), lottoStatistic.getCount6Match());

        BigDecimal formattedRate = BigDecimal.valueOf(lottoStatistic.getReturnRate()).setScale(1, RoundingMode.HALF_UP);
        System.out.println("총 수익률은 " + formattedRate + "%입니다.");
    }

    private void printRankStatistics(String description, String prize, int lottoCount) {
        System.out.println(description + " (" + prize + "원)" + " - " + lottoCount + "개");
    }
}
