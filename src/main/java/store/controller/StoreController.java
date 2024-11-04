package store.controller;

import global.view.InputView;
import store.service.StoreService;

public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    public void setUpWeeklyNumbers() {
        String inputWeeklyNumbers = InputView.inputWeeklyNumbers();
        try {
            storeService.tryUpdateWeeklyNumbers(inputWeeklyNumbers);
        } catch (Exception e) {
            setUpWeeklyNumbers();
        }
    }

    public void setUpBonusNumber() {
        String inputBonusNumber = InputView.inputBonusNumber();
        try {
            storeService.tryUpdateBonusNumber(inputBonusNumber);
        } catch (Exception e) {
            setUpBonusNumber();
        }
    }
}
