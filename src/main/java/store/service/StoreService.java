package store.service;

import static global.utils.StringUtil.WeeklyNumber.parsingWeeklyNumbers;
import static global.utils.StringUtil.WeeklyNumber.splitWeeklyNumberWithSeparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRanking;
import lotto.model.Lotto;
import store.model.Store;
import store.repository.StoreSingleRepository;

public class StoreService {

    private final StoreSingleRepository storeRepository;

    public StoreService(StoreSingleRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void modifyWeeklyNumbers(String inputWeeklyNumbers) {
        List<Integer> weeklyNumbers = parsingWeeklyNumbers(splitWeeklyNumberWithSeparator(inputWeeklyNumbers));

        Store store = get();
        store.setWeeklyNumbers(weeklyNumbers);
        storeRepository.save(store);
    }

    public void modifyBonusNumber(String inputBonusNumber) {
        Store store = get();
        store.setBonusNumber(Integer.parseInt(inputBonusNumber));
        storeRepository.save(store);
    }

    public Store get() {
        return storeRepository.find();
    }

    public List<Integer> getStoredWeeklyNumbers() {
        return storeRepository.find().getWeeklyNumbers();
    }

    public Map<LottoRanking, Integer> getMatchedResult(List<Lotto> lottos) {
        Store store = get();
        List<Integer> weeklyNumbers = store.getWeeklyNumbers();
        Integer bonusNumber = store.getBonusNumber();

        Map<LottoRanking, Integer> results = LottoRanking.getDefaultRankingStates();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            LottoRanking lottoRanking = getLottoRanking(numbers, weeklyNumbers, bonusNumber);
            results.put(lottoRanking, results.get(lottoRanking) + 1);
        }

        return results;
    }

    private LottoRanking getLottoRanking(List<Integer> numbers, List<Integer> weeklyNumbers, int weeklyBonusNumber) {
        int count = countWeeklyNumbers(numbers, weeklyNumbers);
        boolean hasBonusNumber = false;

        if(isContainsWeeklyBonusNumber(numbers, weeklyBonusNumber)) {
            count++;
            hasBonusNumber = true;
        }

        return LottoRanking.matchingLottoRanking(count, hasBonusNumber);
    }

    private int countWeeklyNumbers(List<Integer> numbers, List<Integer> weeklyNumbers) {
        int count = 0;

        for(int number : numbers) {
            if(weeklyNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isContainsWeeklyBonusNumber(List<Integer> numbers, int weeklyBonusNumber) {
        return numbers.contains(weeklyBonusNumber);
    }
}
