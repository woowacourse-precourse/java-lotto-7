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

    public void modifyBonusNumber(int bonusNumber) {
        Store store = get();
        store.setBonusNumber(bonusNumber);
        storeRepository.save(store);
    }

    public Store get() {
        return storeRepository.find();
    }
}
