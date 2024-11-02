package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String buyAmountInput = Console.readLine();

            if (buyAmountInput == null | buyAmountInput.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
            }

            int buyAmount;
            try {
                buyAmount = Integer.parseInt(buyAmountInput);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
            }


            if (buyAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 천원 단위만 입력 가능합니다.");
            }

            int lottoCount = buyAmount / 1000;
            System.out.println(lottoCount + "개를 구매했습니다.");

            List<Lotto> lottoNumbers = new ArrayList<>();
            for (int i = 0; i < lottoCount; i++) {
                List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
                Collections.sort(numbers);
                lottoNumbers.add(new Lotto(numbers));
                System.out.println(lottoNumbers.get(i).getNumbers());
            }
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumberInput = Console.readLine();

            List<Integer> winningNumbers = List.of(winningNumberInput.split(","))
                    .stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();

            int bonusNumbers = Integer.parseInt(bonusNumberInput);

            Map<Rank, Integer> rankCount = new HashMap<>();
            int totalPrize = 0;
            for (Lotto lotto : lottoNumbers) {
                int matchCount = (int) lotto.getNumbers().stream()
                        .filter(winningNumbers::contains)
                        .count();
                boolean matchBonus = lotto.getNumbers().contains(bonusNumbers);
                Rank rank = Rank.calculateRank(matchCount, matchBonus);
                rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
                totalPrize += rank.getPrize();
            }

            System.out.println("\n당첨 통계\n---");
            for (Rank rank : Rank.values()) {
                if (rank != Rank.NONE) {
                    System.out.println(rank.getDescription() + " - " + rankCount.getOrDefault(rank, 0) + "개");
                }
            }

            System.out.println("총 수익률은 " + ((double) totalPrize / buyAmount) * 100 + "%입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
