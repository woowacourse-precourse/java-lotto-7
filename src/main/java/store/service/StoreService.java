package store.service;

import static global.utils.StringUtil.WeeklyNumber.parsingWeeklyNumbers;
import static global.utils.StringUtil.WeeklyNumber.splitWeeklyNumberWithSeparator;

import java.util.List;
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

    public Integer getStoredBonusNumber() {
        return storeRepository.find().getBonusNumber();
    }
}
