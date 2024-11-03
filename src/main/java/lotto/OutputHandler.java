package lotto;

import java.util.List;

public class OutputHandler {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto);
        }
    }

    private static void printLottoNumbers(Lotto lotto) {
        StringBuilder lottoNumbers = new StringBuilder("[");
        List<Integer> numbers = lotto.getNumbers();
        for (int number : numbers) {
            lottoNumbers.append(number).append(", ");
        }
        lottoNumbers.setLength(lottoNumbers.length() - 2);  // 마지막 쉼표 제거
        lottoNumbers.append("]");
        System.out.println(lottoNumbers);
    }

    public static void printResult(int[] matchCount, double revenueRate) {
        StringBuilder result = new StringBuilder();
        result.append("당첨 통계\n");
        result.append("---\n");
        result.append("3개 일치 (5,000원) - ").append(matchCount[3]).append("개\n");
        result.append("4개 일치 (50,000원) - ").append(matchCount[4]).append("개\n");
        result.append("5개 일치 (1,500,000원) - ").append(matchCount[5]).append("개\n");
        result.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(matchCount[7]).append("개\n");
        result.append("6개 일치 (2,000,000,000원) - ").append(matchCount[6]).append("개\n");
        result.append("총 수익률은 ").append(revenueRate).append("%입니다.");
        System.out.println(result);
    }
}
