package store.controller;

import static global.utils.Validator.validateBonusNumber;
import static global.utils.Validator.validateWeeklyNumbers;

import global.view.InputView;
import java.util.List;
import store.service.StoreService;

public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    public void setWeeklyNumbers() {
        String inputWeeklyNumbers = InputView.inputWeeklyNumbers();

        try {
            validateWeeklyNumbers(inputWeeklyNumbers);
        } catch (Exception e) {
            setWeeklyNumbers();
            return;
        }

        //TODO: split과 parsing을 두번 호출? 아니면 어케 넘겨줄 방법? 리팩토링?
        storeService.modifyWeeklyNumbers(inputWeeklyNumbers);
    }

    public void setBonusNumber() {
        String inputBonusNumber = InputView.inputBonusNumber();
        List<Integer> storedWeeklyNumbers = storeService.getStoredWeeklyNumbers();

        try {
            validateBonusNumber(inputBonusNumber, storedWeeklyNumbers);
        } catch(Exception e) {
            setBonusNumber();
            return;
        }

        storeService.modifyBonusNumber(inputBonusNumber);
    }
}
