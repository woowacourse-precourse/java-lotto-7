package lotto.model;

import java.util.List;
import java.util.Map;

public class Purchase {
    private Integer price;
    private Integer lottoCount;
    private List<Lotto> lottos;
    private List<WinningResult> winningResults;
    private Map<Integer, Integer> winningResultStatistics;

    public Purchase(Integer price,
                    Integer lottoCount,
                    List<Lotto> lottos){
        this.price = price;
        this.lottoCount = lottoCount;
        this.lottos = lottos;
    }

    public void setWinningResults(List<WinningResult> winningResults) {
        this.winningResults = winningResults;
    }

    public void setWinningResultsStatistics(Map<Integer, Integer> winningResultStatistics) {
        this.winningResultStatistics = winningResultStatistics;
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Integer, Integer> getWinningResultsStatistics() {
        return winningResultStatistics;
    }

    public Float calculateRateOfReturn() {
        float totalPrice = 0;
        for(WinningResult result : winningResults) {
            totalPrice += result.getWinningPrice();
        }

        Float rateOfReturn = totalPrice / price * 100;

        return rateOfReturn;
    }
}
