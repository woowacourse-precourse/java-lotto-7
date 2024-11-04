package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static Input input = new Input();
    static Output output = new Output();

    public static void main(String[] args) {

        int money = input.askPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLotto(money);
        output.printPurchaseLotto(lottos);

        //당첨 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(readLine().split(","))
                .map(Integer::parseInt).sorted().toList();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(readLine());

        Map<String, Integer> winningResult = new HashMap<>();
        winningResult.put("MATCH_3", 0);
        winningResult.put("MATCH_4", 0);
        winningResult.put("MATCH_5", 0);
        winningResult.put("MATCH_5_BONUS", 0);
        winningResult.put("MATCH_6", 0);


        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            long count = numbers.stream().filter(winningNumbers::contains).count();
            boolean hasBonusNumber = numbers.contains(bonusNumber);

            switch ((int) count) {
                case 3 -> winningResult.put("MATCH_3", winningResult.getOrDefault("MATCH_3", 0) + 1);
                case 4 -> winningResult.put("MATCH_4", winningResult.getOrDefault("MATCH_4", 0) + 1);
                case 5 -> {
                    if (hasBonusNumber) {
                        winningResult.put("MATCH_5_BONUS", winningResult.getOrDefault("MATCH_5_BONUS", 0) + 1);
                    } else {
                        winningResult.put("MATCH_5", winningResult.getOrDefault("MATCH_5", 0) + 1);
                    }
                }
                case 6 -> winningResult.put("MATCH_6", winningResult.getOrDefault("MATCH_6", 0) + 1);
            }
        }

        String result = """
                
                당첨 통계
                ---
                3개 일치 (5,000원) - %s개
                4개 일치 (50,000원) - %s개
                5개 일치 (1,500,000원) - %s개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
                6개 일치 (2,000,000,000원) - %s개
                총 수익률은 %s%%입니다.
                """
                .formatted(
                        winningResult.get("MATCH_3"),
                        winningResult.get("MATCH_4"),
                        winningResult.get("MATCH_5"),
                        winningResult.get("MATCH_5_BONUS"),
                        winningResult.get("MATCH_6"),
                        calculateYield(money, winningResult)
                );
        System.out.println(result);
    }

    public static String calculateYield(int money, Map<String, Integer> winningResult) {
        long totalPrize =
                (winningResult.get("MATCH_3") * 5_000) +
                        (winningResult.get("MATCH_4") * 50_000) +
                        (winningResult.get("MATCH_5") * 1_500_000) +
                        (winningResult.get("MATCH_5_BONUS") * 30_000_000) +
                        (winningResult.get("MATCH_6") * 2_000_000_000L);


        return String.format("%.1f", ((double) totalPrize / money) * 100);
    }
}
