package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.WinningResult;
import lotto.model.WinningStandard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final int LOTTO_RANGE_MIN;
    private final int LOTTO_RANGE_MAX;
    private final int LOTTO_PRICE;
    private final int LOTTO_NUMBER_COUNT;

    public LottoService(int LOTTO_RANGE_MIN,
                        int LOTTO_RANGE_MAX,
                        int LOTTO_PRICE,
                        int LOTTO_NUMBER_COUNT){
        this.LOTTO_RANGE_MIN = LOTTO_RANGE_MIN;
        this.LOTTO_RANGE_MAX = LOTTO_RANGE_MAX;
        this.LOTTO_PRICE = LOTTO_PRICE;
        this.LOTTO_NUMBER_COUNT = LOTTO_NUMBER_COUNT;
    }

    public Lotto registerWinningLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
    public Purchase purchaseLotto(Integer price) {
        Integer lottoCount = price / LOTTO_PRICE;
        List<Lotto> lottos = generateLotto(lottoCount);

        return new Purchase(price, lottoCount, lottos);
    }

    public Purchase calculateLottoResult(Purchase purchase, Lotto winningLotto, Integer bonusNumber) {
        List<Lotto> purchaseLottos= purchase.getLottos();
        List<WinningResult> winningResults = new ArrayList<>();

        for (Lotto lotto : purchaseLottos){
            winningResults.add(calculateWinningResult(lotto, winningLotto, bonusNumber));
        }
        purchase.setWinningResults(winningResults);

        Map<Integer, Integer> winningResultStatistics = calculateWinningResultsStatistics(winningResults);
        purchase.setWinningResultsStatistics(winningResultStatistics);

        return purchase;
    }

    private List<Lotto> generateLotto(Integer count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_NUMBER_COUNT);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private WinningResult calculateWinningResult(Lotto purchaseLotto, Lotto winningLotto, Integer bonuseNumber) {
        List<Integer> purchaseLottoNumbers = purchaseLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();

        long commonCount = purchaseLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
        boolean bonusCount = purchaseLottoNumbers.contains(bonuseNumber);

        Integer winningRank = getWinningRank(commonCount, bonusCount);
        Integer winningPrice = getWinningPrice(winningRank);

        return new WinningResult(purchaseLotto, winningLotto, winningRank,  winningPrice);
    }

    private Integer getWinningRank(long commonCount, boolean bonusCount) {
        if(commonCount == 6){
            return 1;
        }
        if(commonCount == 5 && bonusCount){
            return 2;
        }
        if(commonCount == 5){
            return 3;
        }
        if(commonCount == 4){
            return 4;
        }
        if(commonCount == 3){
            return 5;
        }
        return 6;
    }

    private Integer getWinningPrice(Integer winningRank) {
        WinningStandard standard = WinningStandard.WINNING_STANDARDS.stream()
                .filter(s -> s.getRank() == winningRank)
                .findFirst()
                .get();
        return standard.getPrice();
    }

    private Map<Integer, Integer> calculateWinningResultsStatistics(List<WinningResult> winningResults){
        Map<Integer, Integer> winningResultStatistics = new HashMap<>();

        for(WinningResult winningResult : winningResults) {
            Integer rank = winningResult.getWinningRank();
            winningResultStatistics.put(rank, winningResultStatistics.getOrDefault(rank, 0) + 1);
        }

        return winningResultStatistics;
    }
}
