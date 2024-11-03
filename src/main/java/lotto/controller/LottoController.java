package lotto.controller;

import lotto.Service.LottoService;
import lotto.exception.InvalidInputException;
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

        List<Integer> result = service.calculateResult();
        double rate = service.calculateRate();
        viewFacade.printResult(result, rate);
    }

    private void repeatUntilPurchaseValid() {
        while (true) {
            try {
                String purchaseAmount = viewFacade.getPurchaseAmount();
                int num = Integer.parseInt(purchaseAmount);
                service.generateUserNumbers(num);
                return;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
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
                System.out.println("[ERROR] 숫자를 입력하세요.");
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
            } catch (InvalidInputException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            }
        }
    }
}
