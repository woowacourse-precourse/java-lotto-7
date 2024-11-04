package lotto.model.lottoBuyer;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoRankAward;
import lotto.model.lotto.LottoWinningNumbers;

import java.util.*;

public class LottoBuyer {

    private final int lottoPurchaseAmount;
    private final LottoRepository lottoRepository;
    private double totalLottoProfit = 0;
    private double lottoProfitRate;
    private final Map<LottoRankAward, Integer> matchCountResult = new LinkedHashMap<>();

    public LottoBuyer(int lottoPrice, LottoRepository lottoRepository){
        this.lottoPurchaseAmount = lottoPrice;
        this.lottoRepository = lottoRepository;
        Arrays.stream(LottoRankAward.values()).forEach(rank -> matchCountResult.put(rank, 0));
    }

    public void addLotto(Lotto lotto){
        lottoRepository.saveLotto(lotto);
    }

    public void updateLottoProfit(int lottoProfit){
        totalLottoProfit += lottoProfit;
    }

    public double calculateProfitRate(){
        lottoProfitRate = (totalLottoProfit / lottoPurchaseAmount) * 100;
        return lottoProfitRate;
    }

    public Map<LottoRankAward, Integer> calculateLottoResult(LottoWinningNumbers lottoWinningNumbers){
        Set<Integer> winningNumbers = lottoWinningNumbers.getWinningNumbers();
        int bonusNumber = lottoWinningNumbers.getBonusNumber();

        for (Lotto lotto : lottoRepository.findAllLotto()){
            processLottoResult(lotto, winningNumbers, bonusNumber);
        }
        return matchCountResult;
    }

    private void processLottoResult(Lotto lotto, Set<Integer> winningNumbers, int bonusNumber) {
        int matchedCount = calculateMatchedCount(lotto, winningNumbers);
        boolean isBonusNumberMatched = (matchedCount == 5) && lotto.getLottoNumbers().contains(bonusNumber);

        LottoRankAward rank = LottoRankAward.findRank(matchedCount, isBonusNumberMatched);
        if (rank != null) {
            updateMatchCountResult(rank);
            updateLottoProfit(rank.getWinningMoneyPrize());
        }
    }

    private int calculateMatchedCount(Lotto lotto, Set<Integer> winningNumbers) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void updateMatchCountResult(LottoRankAward rank) {
        matchCountResult.put(rank, matchCountResult.get(rank) + 1);
    }



}






