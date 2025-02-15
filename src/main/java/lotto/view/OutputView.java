package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGrade;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottos(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        int size = lottos.getLottos().size();
        stringBuilder.append(size)
                .append("개를 구매했습니다.\n");

        String purchasedLottos = lottos.getLottos().stream()
                .map(lotto -> formatLotto(lotto))
                .collect(Collectors.joining("\n"));

        stringBuilder.append(purchasedLottos);

        System.out.println(stringBuilder);
    }

    private String formatLotto(Lotto lotto) {
        String sortedLottoNumbers = lotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return "[" + sortedLottoNumbers + "]";
    }

    public void printResult(Map<LottoGrade, Integer> lottoCountMap) {
        Arrays.stream(LottoGrade.values())
                .forEach(lottoGrade -> lottoCountMap.computeIfAbsent(lottoGrade, k -> 0));

        String lottoResult = lottoCountMap.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(LottoGrade.FAIL))
                .sorted(lottoPriceNaturalOrder())
                .map(entry -> formatEachResult(entry))
                .collect(Collectors.joining("\n"));

        System.out.println("당첨 통계\n---\n" + lottoResult);
    }

    private Comparator<Map.Entry<LottoGrade, Integer>> lottoPriceNaturalOrder() {
        return (entry1, entry2) -> Long.compare(entry1.getKey().getPrice(), entry2.getKey().getPrice());
    }

    private String formatEachResult(Map.Entry<LottoGrade, Integer> entry) {
        StringBuilder stringBuilder = new StringBuilder();

        LottoGrade lottoGrade = entry.getKey();
        int target = lottoGrade.getTarget();
        String priceFormat = String.format("%,d", lottoGrade.getPrice());
        int count = entry.getValue();

        stringBuilder.append(target).append("개 일치");
        appendIfSecond(entry, stringBuilder);
        stringBuilder.append(" (").append(priceFormat).append("원)");
        stringBuilder.append(" - ").append(count).append("개");

        return stringBuilder.toString();
    }

    private void appendIfSecond(Map.Entry<LottoGrade, Integer> entry, StringBuilder stringBuilder) {
        if (entry.getKey().equals(LottoGrade.SECOND)) {
            stringBuilder.append(", 보너스 볼 일치");
        }
    }

    public void printProfit(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
