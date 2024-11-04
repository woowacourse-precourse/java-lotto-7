package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoView {

    public int requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요:");
        String input = Console.readLine();
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
        return amount;
    }

    public List<Integer> requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요 (예: 1,2,3,4,5,6):");
        String input = Console.readLine();
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (numbers.size() != 6 || !numbers.stream().allMatch(n -> n >= 1 && n <= 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자 6개여야 합니다.");
        }
        return numbers;
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요:");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    public void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
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