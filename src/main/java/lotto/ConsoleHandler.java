package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleHandler {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        System.out.println();
        return invertNumber(money);
    }

    private int invertNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printPurchasedLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        sortLottoNumbers(numbers);
        System.out.println(numbers);
    }

    private void sortLottoNumbers(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        System.out.println();
        return convertToNumbers(winningNumbers);
    }

    private List<Integer> convertToNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        return Arrays.stream(numbers)
                .map(this::invertNumber)
                .collect(Collectors.toList());
    }

    public int inputWinningLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        return invertNumber(bonusNumber);
    }

    public void printWinningResult(Map<Rank, Integer> winningCountsByRank, Map<Rank, PrizeInfo> rankInfo) {
        System.out.println("당첨 통계");
        System.out.println("---");

        rankInfo.keySet().stream()
                .filter(rank -> rank.getPrintOrder() != null)
                .sorted(Comparator.comparingInt(Rank::getPrintOrder))
                .forEach(rank -> {
                    PrizeInfo prizeInfo = rankInfo.get(rank);
                    int winningCount = winningCountsByRank.getOrDefault(rank, 0);
                    printRankResult(prizeInfo, winningCount);
                });
    }

    private void printRankResult(PrizeInfo prizeInfo, int winningCount) {
        System.out.print(prizeInfo.getMatchCount() + "개 일치");
        if (prizeInfo.isMatchBonus()) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.print(" (" + prizeInfo.getPrize() + "원) - ");
        System.out.println(winningCount + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 "+ profitRate +"% 입니다.");
    }

}
