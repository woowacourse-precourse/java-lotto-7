package lotto.model.lottoBuyer;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoConstant;
import lotto.model.lotto.LottoRankAward;
import lotto.model.lotto.LottoWinningNumbers;

import java.util.*;

public class LottoBuyer {

    private final int lottoPurchaseAmount;
    private final LottoRepository lottoRepository;
    private double totalLottoProfit = 0;
    private final Map<LottoRankAward, Integer> rankCountsStorage = new LinkedHashMap<>();

    public LottoBuyer(int lottoPrice){
        this.lottoPurchaseAmount = lottoPrice;
        this.lottoRepository = new InMemoryLottoRepository();
        initRankCounts();
    }

    private void initRankCounts(){
        Arrays.stream(LottoRankAward.values()).forEach(rank -> rankCountsStorage.put(rank, 0));
    }

    public void addLotto(Lotto lotto){
        lottoRepository.saveLotto(lotto);
    }

    public void updateLottoProfit(int lottoProfit){
        totalLottoProfit += lottoProfit;
    }

    public double calculateProfitRate(){
        return (totalLottoProfit / lottoPurchaseAmount) * 100;
    }

    public Map<LottoRankAward, Integer> calculateLottoResult(LottoWinningNumbers lottoWinningNumbers){
        Set<Integer> winningNumbers = lottoWinningNumbers.getWinningNumbers();
        int bonusNumber = lottoWinningNumbers.getBonusNumber();
        for (Lotto lotto : lottoRepository.findAllLotto()){
            processLottoResult(lotto, winningNumbers, bonusNumber);
        }
        return rankCountsStorage;
    }

    private void processLottoResult(Lotto lotto, Set<Integer> winningNumbers, int bonusNumber) {
        int matchedCount = calculateMatchedCount(lotto, winningNumbers);
        boolean isBonusNumberMatched = (matchedCount == LottoConstant.REQUIRED_MATCH_COUNT_FOR_BONUS) && lotto.getLottoNumbers().contains(bonusNumber);
        LottoRankAward rank = LottoRankAward.findLottoRank(matchedCount, isBonusNumberMatched);
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
        rankCountsStorage.put(rank, rankCountsStorage.get(rank) + 1);
    }

}


