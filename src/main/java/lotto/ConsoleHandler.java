package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleHandler {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readValidNumber();
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
        System.out.println(sortLottoNumbers(numbers));
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readValidNumbers();
    }

    public int inputWinningLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readValidNumber();
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
        System.out.print(" (" + formatWithComma(prizeInfo.getPrize()) + "원) - ");
        System.out.println(winningCount + "개");
    }

    private String formatWithComma(int number) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(number);
    }

    public void printProfitRate(double profitRate) {
        System.out.print("총 수익률은 " + profitRate + "%입니다.");
    }

    private int readValidNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                System.out.println();
                return invertNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> readValidNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                System.out.println();
                return invertNumbers(input.split(","));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int invertNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private List<Integer> invertNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(this::invertNumber)
                .collect(Collectors.toList());
    }

}
