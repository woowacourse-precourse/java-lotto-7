package lotto.controller;

import lotto.service.input.InputService;
import lotto.service.input.InputServiceImpl;
import lotto.service.input.converter.MoneyInputConverterService;
import lotto.service.input.validator.MoneyInputValidatorService;
import lotto.service.purchase.LottoMachineService;
import lotto.service.purchase.LottoMachineServiceImpl;
import lotto.service.purchase.PurchaseService;
import lotto.service.purchase.PurchaseServiceImpl;
import lotto.view.UserInput;
import lotto.view.constant.InputInfo;

public class PurchaseController {

    private static PurchaseController instance;

    private final InputService<Long> inputService;

    public PurchaseController () {
        inputService = new InputServiceImpl<>(new MoneyInputValidatorService(), new MoneyInputConverterService());
    }

    public void run(){
        getMoneyInput();
        PurchaseService purchase = PurchaseServiceImpl.getTrade(inputService);

        issueALottoTicket(purchase);
    }

    private void issueALottoTicket(PurchaseService purchase) {
        LottoMachineService lottoMachineService = LottoMachineServiceImpl.getInstance(purchase);
        lottoMachineService.updateLottoTicket();
    }

    private void getMoneyInput() {
        String input = UserInput.get(InputInfo.PURCHASE_AMOUNT.guide());
        try {
            inputService.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getMoneyInput();
        }
    }

    public static PurchaseController getController() {
        if (instance == null) {
            instance = new PurchaseController();
        }
        return instance;
    }
}
