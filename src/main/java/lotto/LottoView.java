package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoView {

    public int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = Integer.parseInt(input);  // 잘못된 입력은 NumberFormatException 발생
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
        return amount;
    }

    public List<Integer> requestWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.asList(Console.readLine().split(",")).stream()
                .map(Integer::parseInt)
                .toList();
    }

    public int requestBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void displayPurchaseLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayResults(Map<LottoRank, Integer> resultSummary, double earningsRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.MISS) {
                System.out.printf("%s - %d개\n", rank.getDescription(), resultSummary.get(rank));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningsRate);
    }
}
