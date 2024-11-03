package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Lotto winningNumber;
    private final int bonusNumber;
    private final Map<LottoPrize, Integer> results;


    public LottoResult(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;

        results = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            results.put(prize, 0); // 초기값 0으로 설정
        }
    }

    public void setResults(LottoPrize prize) {
        results.put(prize, results.get(prize) + 1);
    }

    public int countMatches(List<Integer> myLotto){
        List<Integer> commonNumbers = new ArrayList<>(myLotto);
        commonNumbers.retainAll(winningNumber.getNumbers());
        return commonNumbers.size();
    }

    public LottoPrize calculateResults(Lotto myLotto){
        int matchCount = countMatches(myLotto.getNumbers());
        Boolean containBonus = winningNumber.getNumbers().contains(bonusNumber);
        return LottoPrize.valueOf(matchCount, containBonus);
    }

    public void printResults() {
        OutputView.printResultMessage();
        for (Map.Entry<LottoPrize, Integer> entry : results.entrySet()) {
            LottoPrize prize = entry.getKey();
            int count = entry.getValue();
            OutputView.printLottoResult(prize.getDescription(), count);
        }
    }


}
