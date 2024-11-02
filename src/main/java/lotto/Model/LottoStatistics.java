package lotto.Model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoResult, Integer> resultCounts = new EnumMap<>(LottoResult.class);
    private final int price;

    public LottoStatistics(int price) {
        this.price = price;
        initializeResultCounts();
    }

    private void initializeResultCounts() {
        for(LottoResult result : LottoResult.values()) {
            resultCounts.put(result, 0);
        }
    }

    private void updateResultCount(LottoResult result) {
        if(result != null){
            resultCounts.put(result, resultCounts.get(result) + 1);
        }
    }

    public void processTickets(List<Lotto> allLotto, WinningLotto winningLotto){
        for(Lotto ticket : allLotto){
            LottoResult result = winningLotto.getMatchResult(ticket);
            updateResultCount(result);
        }
    }

    public int calculateTotalPrize(){
        int totalPrize = 0;
        for(LottoResult result : LottoResult.values()){
            totalPrize += result.getWinningAmount() * resultCounts.get(result);
        }
        return totalPrize;
    }

    public double calculateProfitRate(){
        int totalPrize = calculateTotalPrize();
        double profitRate = ((double) totalPrize / price) * 100;
        String formattedProfitRate = String.format("%.1f", profitRate);
        return Double.parseDouble(formattedProfitRate);
    }

    public Map<LottoResult, Integer> getResultCounts() {
        return resultCounts;
    }
}
