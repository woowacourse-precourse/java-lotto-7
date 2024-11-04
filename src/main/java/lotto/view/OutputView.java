package lotto.view;

import lotto.model.LottoProcessor;
import lotto.model.LottoType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPurchaseNumber(int purchaseAmount) {
        int purchaseNumber = purchaseAmount / 1000;
        System.out.println(purchaseNumber + "개를 구매했습니다.");
    }

    public void printWinningStatistics(Map<LottoType, Integer> lottoPickResult) {
        System.out.println("당첨 통계\n---");
        List<LottoType> lottoTypes = Arrays.stream(LottoType.values())
                .filter(t -> t.getWinnings() > 0)
                .toList();

        for (LottoType lottoType : lottoTypes) {
            Integer count = lottoPickResult.get(lottoType);
            String information = lottoType.getInformation();
            System.out.printf("%s %d개\n", information, count);
        }
    }

    public void printTotalReturn(LottoProcessor lottoProcessor, int purchaseAmount) {
        System.out.printf("총 수익률은 %.1f%%입니다.", (float)lottoProcessor.calculateWinnings() / purchaseAmount * 100);
    }

    public void PrintPurchaseHistory(List<List<Integer>> numbers) {
        StringBuilder sb;

        for (List<Integer> numberList : numbers) {
            sb = new StringBuilder();

            String purchaseLottoNumbers = getPurchaseLottoNumbers(sb, numberList);
            System.out.printf("[%s]\n", purchaseLottoNumbers);
        }
    }

    private String getPurchaseLottoNumbers(StringBuilder sb, List<Integer> numberList) {
        for (Integer number : numberList) {
            sb.append(number + ", ");
        }

        return sb.substring(0, sb.length() - 2);
    }
}
