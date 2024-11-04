package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Application {


    public static void main(String[] args) {
        Genarator genarator = new Genarator();
        Input input = new Input();

        try {
            int amount = getPurchaseAmount();
            List<Lotto> lottos = generateLottos(amount, genarator);
            calculateAndDisplayResults(lottos, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.print("구입금액을 입력해 주세요.\n");
        String amountInput = Console.readLine();

        try {
            int amount = Integer.parseInt(amountInput);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static List<Lotto> generateLottos(int amount, Genarator genarator) {
        List<Lotto> lottos = genarator.autoGen(amount);
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    private static void calculateAndDisplayResults(List<Lotto> lottos, Input input) {
        Lotto winNo = input.winner();
        int bonusNo = input.bonus(winNo);

        Map<LottoRank, Integer> results = LottoChecker.checkResults(lottos, winNo.getNumbers(), bonusNo);
        String resultSummary = LottoChecker.generateResultSummary(results);
        System.out.println(resultSummary);

        double profitRate = calculateProfitRate(lottos.size(), results);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }


    private static double calculateProfitRate(int lottoCount, Map<LottoRank, Integer> results) {
        int totalPrize = 0;

        for (Map.Entry<LottoRank, Integer> entry : results.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }

        return (double) totalPrize / (lottoCount * 1000) * 100;
    }

}
