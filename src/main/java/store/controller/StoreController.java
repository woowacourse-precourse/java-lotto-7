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

        //TODO: split과 parsing을 두번 호출? 아니면 어케 넘겨줄 방법? 리팩토링?
        storeService.modifyWeeklyNumbers(inputWeeklyNumbers);
    }

    public void setBonusNumber() {
        String inputBonusNumber = storeInputView.inputBonusNumber();

        try {
            validateBonusNumber(inputBonusNumber)
        } catch(Exception e) {
            setBonusNumber();
            return;
        }

        storeService.modifyBonusNumber(inputBonusNumber);
    }
}
