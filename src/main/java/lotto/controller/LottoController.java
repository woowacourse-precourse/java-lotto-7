package lotto.controller;

import lotto.Service.LottoService;
import lotto.enumMessage.ErrorMessage;
import lotto.model.Lotto;
import lotto.view.ViewFacade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final ViewFacade viewFacade;
    private final LottoService service;

    public LottoController(ViewFacade viewFacade, LottoService service) {
        this.viewFacade = viewFacade;
        this.service = service;
    }

    public void run() {
        repeatUntilPurchaseValid();
        viewFacade.printUserLotto(service.getUserNumbers());

        repeatUntilLottoValid();
        repeatUntilBonusNumberValid();

        service.calculate();
        viewFacade.printResult(service.getResult(), service.getRate());
    }

    private void repeatUntilPurchaseValid() {
        while (true) {
            try {
                String purchaseAmount = viewFacade.getPurchaseAmount();
                int num = Integer.parseInt(purchaseAmount);
                service.generateUserNumbers(num);
                return;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_VALUE.getMessage());
            }
        }
    }

    private void repeatUntilLottoValid() {
        while (true) {
            try {
                String[] lottoNumber = viewFacade.getLottoNumber().split(",");
                List<Integer> lottoNumberList = Arrays.stream(lottoNumber)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                service.generateLotto(new Lotto(lottoNumberList));
                return;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_VALUE.getMessage());
            }
        }
    }

    private void repeatUntilBonusNumberValid() {
        while (true) {
            try {
                String bonusNumber = viewFacade.getBonusNumber();
                int num = Integer.parseInt(bonusNumber);
                service.generateBonusNumber(num);
                return;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_VALUE.getMessage());
            }
        }
    }
}
