package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Output {
    private final LottoManager lottoManager = new LottoManager();

    public void printGetMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printGetWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printGetBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printPurchaseHistory(Customer customer) {
        List<Lotto> purchaseHistory = customer.getLottoTickets();
        System.out.println(purchaseHistory.size() + "개를 구매했습니다.");
        purchaseHistory.forEach(this::printLotto);
    }

    public void printWinningStatistics(List<Rank> rankResult) {
        System.out.println("당첨 통계\n---");
        Map<Rank, Integer> rankCountMap = lottoManager.getRankCountMap(rankResult);

        for (Rank rank : Rank.RANK_ASC) {
            int count = rankCountMap.getOrDefault(rank, 0);
            String message = rank.getMessage() + count + "개";
            System.out.println(message);
        }

        printYield(rankResult);
    }


    public void printYield(List<Rank> rankResult) {
        double yield = lottoManager.getYield(rankResult);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
