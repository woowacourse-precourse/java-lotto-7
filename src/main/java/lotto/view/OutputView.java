package lotto.view;

import lotto.domain.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void printLotto(List<Lotto> lottoList, int lottoNum) {
        System.out.println(lottoNum + Constants.PURCHASE_LOTTO_OUTPUT);

        for(int i=0; i<lottoNum; i++){
            List<Integer> numbers = lottoList.get(i).getNumbers();

            String joinLotto = String.join(", ", numbers.stream().map(String::valueOf).toArray(String[]::new));
            System.out.println("[" + joinLotto + "]");
        }
        System.out.println();
    }

    public void totalLotto(LottoResult result) {
        Map<LottoRank, Integer> lottoResults = result.getLottoResult();
        double rate = result.getRate();

        System.out.println(Constants.RESULT_LOTTO_OUTPUT);
        List<Map.Entry<LottoRank, Integer>> sortedResults = sortLottoResultsByMatchCount(lottoResults);
        for(Map.Entry<LottoRank, Integer> entry : sortedResults){
            System.out.println(entry.getKey().getMatchCount()+"개 일치 ("+entry.getKey().getPrice()+"원) - "+lottoResults.get(entry.getKey())+"개");
        }
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    private List<Map.Entry<LottoRank, Integer>> sortLottoResultsByMatchCount(Map<LottoRank, Integer> lottoResults) {
        // Map의 엔트리를 리스트로 변환하고, matchCount를 기준으로 오름차순으로 정렬
        return lottoResults.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey().getMatchCount())) // matchCount 기준 정렬
                .collect(Collectors.toList());
    }

}
