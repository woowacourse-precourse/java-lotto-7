package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoView {
    public int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            return LottoValidator.validatePurchaseAmountInput(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public WinningNumber inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return new WinningNumber(numbers, bonusNumber);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> {
                    String bonusMatch = rank == Rank.SECOND ? ", 보너스 볼 일치" : "";
                    System.out.printf("%d개 일치%s (%s원) - %d개\n",
                            rank.getMatchCount(),
                            bonusMatch,
                            formatPrize(rank.getPrize()),
                            result.getResults().get(rank)
                    );
                });

        double profitRate = result.calculateProfitRate(purchaseAmount); // 전달된 purchaseAmount 사용
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize); // 숫자를 천 단위로 포맷
    }
}
