package lotto.service;

import static global.constant.GlobalStatic.LOTTO_END_NUMBER;
import static global.constant.GlobalStatic.LOTTO_NUMBER_COUNTS;
import static global.constant.GlobalStatic.LOTTO_START_NUMBER;
import static global.constant.GlobalStatic.PURCHASE_AMOUNT_UNIT;
import static global.utils.GlobalUtil.LottoUtil.sortingNumbers;
import static global.utils.GlobalUtil.PurchaseAmountUtil.parsingPurchaseAmount;
import static global.utils.Validator.validatePurchaseAmount;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import lotto.repository.LottoRepositoryImpl;
import store.service.StoreService;

public class LottoService {

    private final StoreService storeService;
    private final LottoRepositoryImpl lottoRepository;

    public LottoService(StoreService storeService, LottoRepositoryImpl lottoRepository) {
        this.storeService = storeService;
        this.lottoRepository = lottoRepository;
    }

    public void tryGenerateByPurchaseAmount(String inputPurchaseAmount) {
        validatePurchaseAmount(inputPurchaseAmount);
        BigInteger purchaseAmount = parsingPurchaseAmount(inputPurchaseAmount);
        BigInteger count = purchaseAmount.divide(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT));
        for (BigInteger i = BigInteger.ZERO; i.compareTo(count) < 0; i = i.add(BigInteger.ONE)) {
            generate(sortingNumbers(generateRandomNumbers()));
        }
    }

    public void generate(List<Integer> numbers) {
        lottoRepository.save(new Lotto(numbers));
    }

    public int count() {
        return lottoRepository.count();
    }

    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNTS);
    }

    public List<Lotto> getAll() {
        return lottoRepository.findAll();
    }

    public Map<LottoRank, Integer> getMatchedResults() {
        List<Lotto> lottos = getAll();
        return storeService.getMatchedResult(lottos);
    }

    public double calculateProfitRate(Map<LottoRank, Integer> matchedResults) {
        long purchasedAmount = getAll().size() * PURCHASE_AMOUNT_UNIT;
        double totalProfit = calculateTotalProfit(matchedResults);

        double profitRate = (totalProfit / purchasedAmount) * 100.00;
        BigDecimal halfUpRate = new BigDecimal(profitRate).setScale(1, RoundingMode.HALF_UP);

        return halfUpRate.doubleValue();
    }

    public double calculateTotalProfit(Map<LottoRank, Integer> matchedResults) {
        double totalProfit = 0.0;

        for (LottoRank rank : LottoRank.values()) {
            int count = matchedResults.get(rank);
            totalProfit += rank.getPrize() * count;
        }

        return totalProfit;
    }
}
