package store.controller;

import static global.utils.Validator.validateWeeklyNumbers;

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

        try {
            validateWeeklyNumbers(inputWeeklyNumbers);
        } catch (Exception e) {
            setWeeklyNumbers();
            return;
        }

    }
}
