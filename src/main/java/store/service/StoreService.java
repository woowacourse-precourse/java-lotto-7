package store.service;

import static global.utils.GlobalUtil.WeeklyNumber.parsingWeeklyNumbers;
import static global.utils.GlobalUtil.WeeklyNumber.splitWeeklyNumberWithSeparator;
import static global.utils.Validator.validateBonusNumber;
import static global.utils.Validator.validateWeeklyNumbers;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import store.model.Store;
import store.repository.StoreRepositoryImpl;

public class StoreService {

    private final StoreRepositoryImpl storeRepository;

    public StoreService(StoreRepositoryImpl storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store get() {
        return storeRepository.findOne();
    }

    public void tryUpdateWeeklyNumbers(String inputWeeklyNumbers) {
        validateWeeklyNumbers(inputWeeklyNumbers);
        List<String> splitResult = splitWeeklyNumberWithSeparator(inputWeeklyNumbers);
        List<Integer> weeklyNumbers = parsingWeeklyNumbers(splitResult);
        updateWeeklyNumbers(weeklyNumbers);
    }

    private void updateWeeklyNumbers(List<Integer> weeklyNumbers) {
        Store store = get();
        store.updateWeeklyNumbers(weeklyNumbers);
        storeRepository.save(store);
    }

    public void tryUpdateBonusNumber(String inputBonusNumber) {
        List<Integer> storedWeeklyNumbers = getStoredWeeklyNumbers();
        validateBonusNumber(inputBonusNumber, storedWeeklyNumbers);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        updateBonusNumber(bonusNumber);
    }

    private void updateBonusNumber(int bonusNumber) {
        Store store = get();
        store.updateBonusNumber(bonusNumber);
        storeRepository.save(store);
    }

    public List<Integer> getStoredWeeklyNumbers() {
        return storeRepository.findOne().getWeeklyNumbers();
    }

    public Map<LottoRank, Integer> getMatchedResult(List<Lotto> lottos) {
        Store store = get();
        List<Integer> weeklyNumbers = store.getWeeklyNumbers();
        Integer bonusNumber = store.getBonusNumber();
        Map<LottoRank, Integer> results = LottoRank.getDefaultRankingStates();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            LottoRank lottoRanking = getLottoRanking(numbers, weeklyNumbers, bonusNumber);
            results.put(lottoRanking, results.get(lottoRanking) + 1);
        }

        return results;
    }

    private LottoRank getLottoRanking(List<Integer> numbers, List<Integer> weeklyNumbers, int weeklyBonusNumber) {
        int count = countWeeklyNumbers(numbers, weeklyNumbers);
        boolean hasBonusNumber = false;

        if (isContainsWeeklyBonusNumber(numbers, weeklyBonusNumber)) {
            count++;
            hasBonusNumber = true;
        }

        return LottoRank.matchingLottoRanking(count, hasBonusNumber);
    }

    private int countWeeklyNumbers(List<Integer> numbers, List<Integer> weeklyNumbers) {
        int count = 0;

        for (int number : numbers) {
            if (weeklyNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isContainsWeeklyBonusNumber(List<Integer> numbers, int weeklyBonusNumber) {
        return numbers.contains(weeklyBonusNumber);
    }
}
