package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class OutputView {

    public void printPurchaseCount(int lottoCount) {
        printEmptyLine();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottos(List<Lotto> lottos) {
        lottos.forEach(this::printLotto);
        printEmptyLine();
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);

        String outputNumbers = numbers.stream()
                .map(String::valueOf) // 각 숫자를 문자열로 변환
                .collect(Collectors.joining(", "));
        System.out.printf("[%s]\n", outputNumbers);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printLottoResults(Map<Ranking, Integer> lottoResults) {
        Arrays.stream(Ranking.values()).sorted(Comparator.comparingInt(Ranking::getMatchCount))
                .forEach(ranking -> printLottoResult(lottoResults, ranking));
    }

    public void printLottoResult(Map<Ranking, Integer> lottoResults, Ranking ranking) {
        int count = lottoResults.getOrDefault(ranking, 0);
        if (ranking.isRequireMatchBonus()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", ranking.getMatchCount(), ranking.getPrize(), count);
        } else {
            System.out.printf("%d개 일치 (%,d원) - %d개\n", ranking.getMatchCount(), ranking.getPrize(), count);
        }
    }

}
