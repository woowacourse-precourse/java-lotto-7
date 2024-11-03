package store.controller;

import static global.utils.StringUtil.WeeklyNumber.parsingWeeklyNumbers;
import static global.utils.StringUtil.WeeklyNumber.splitWeeklyNumberWithSeparator;
import static global.utils.Validator.validateParsedWeeklyNumbers;
import static global.utils.Validator.validateSplitWeeklyNumbers;

import java.util.ArrayList;
import java.util.List;
import store.service.StoreService;
import store.view.StoreInputView;
import store.view.StoreOutputView;

public class StoreController {

    private final StoreInputView storeInputView;
    private final StoreOutputView storeOutputView;
    private final StoreService storeService;

    public StoreController(StoreInputView storeInputView, StoreOutputView storeOutputView, StoreService storeService) {
        this.storeInputView = storeInputView;
        this.storeOutputView = storeOutputView;
        this.storeService = storeService;
    }

    public void setWeeklyNumbers() {

        String inputWeeklyNumbers = storeInputView.inputWeeklyNumbers();
        List<String> splitInput = splitWeeklyNumberWithSeparator(inputWeeklyNumbers);
        List<Integer> weeklyNumbers = new ArrayList<>();

        try {
            validateSplitWeeklyNumbers(splitInput);
            weeklyNumbers = parsingWeeklyNumbers(splitInput);
            validateParsedWeeklyNumbers(weeklyNumbers);
        } catch (Exception e) {
            setWeeklyNumbers();
        }
    }
}
