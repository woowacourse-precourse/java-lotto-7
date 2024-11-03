package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.utils.Utils;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoAmount;
    private final List<Lotto> userLottoList = new ArrayList<>();
    private final Map<WinningResult, Integer> winningResultCount = new HashMap<>();
    private int totalPrize = 0;

    public LottoGame(int lottoCost){

        this.lottoAmount = lottoCost / LOTTO_PRICE;
        for (WinningResult result : WinningResult.values()) {
            winningResultCount.put(result, 0);
        }
    }

    public void generateWinningResults(List<Integer> winningNumbers, int bonusNumber){

        for (Lotto lotto : userLottoList) {

            int matchCount = checkMatchCount(lotto, winningNumbers);

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            WinningResult result = WinningResult.matchCount(matchCount, bonusMatch);

            if (result != null) {
                winningResultCount.put(result, winningResultCount.get(result) + 1);
                totalPrize += result.getPrize();
            }

        }

        OutputView.printLottoResult(winningResultCount,calculateProfitStatics(totalPrize));

    }

    public List<Lotto> generateUserLotto(){

        for(int i = 0; i < lottoAmount; i++){

            userLottoList.add(new Lotto(Utils.generateLottoNumber()));
        }

        return userLottoList;
    }

    public List<Lotto> getUserLottoList() {
        return userLottoList;
    }

    private int checkMatchCount(Lotto lotto, List<Integer> winningNumbers) {

        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public double calculateProfitStatics(int totalPrize){

        int totalSpent = userLottoList.size() * 1000;

        return (double) totalPrize / totalSpent * 100;
    }

    public Map<WinningResult, Integer> getWinningResultCount() {
        return winningResultCount;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
