package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.BonusNumberDuplicateException;
import lotto.exception.BonusNumberOutOfBoundException;
import lotto.exception.LottoInvalidException;
import lotto.exception.PurchaseNumberInvalidException;
import lotto.exception.PurchaseNumberOverFlowException;
import lotto.exception.PurchaseNumberUnderFlowException;
import lotto.exception.PurchaseNumberUnitException;
import lotto.lottoMachine.Lotto;

public class InputController {
    private static final String INPUT_LOTTO_NUMBER_DESCRIPTION = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_DESCRIPTION = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_PURCHASE_NUMBER_DESCRIPTION = "구입금액을 입력해 주세요.";
    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN_PURCHASE_PRICE = 1_000;
    private static final int MAX_PURCHASE_PRICE = 2_147_483_000;

    private static ExceptionController exceptionController = new ExceptionController();

    public Integer getPurchaseNumber() {
        while(true) {
            System.out.println(INPUT_PURCHASE_NUMBER_DESCRIPTION);
            String input = Console.readLine();
            try {
                return validatePurchaseNumberInput(input) / LOTTO_PRICE;
            } catch (IllegalArgumentException e) {
                exceptionController.printException(e);
            } finally {
                System.out.println();
            }
        }
    }

    private Integer validatePurchaseNumberInput(String input) {
        int purchaseNumber;
        try {
            purchaseNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new PurchaseNumberInvalidException();
        }

        if (purchaseNumber > MAX_PURCHASE_PRICE) {
            throw new PurchaseNumberOverFlowException();
        }

        if(purchaseNumber < MIN_PURCHASE_PRICE) {
            throw new PurchaseNumberUnderFlowException();
        }

        if(purchaseNumber % LOTTO_PRICE != 0) {
            throw new PurchaseNumberUnitException();
        }

        return purchaseNumber;
    }

    public Lotto getLotto() {
        while(true) {
            System.out.println(INPUT_LOTTO_NUMBER_DESCRIPTION);
            String input = Console.readLine();
            try {
                return validateLottoInput(input);
            } catch (IllegalArgumentException e) {
                exceptionController.printException(e);
            } finally {
                System.out.println();
            }
        }
    }

    private Lotto validateLottoInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for(String numberString : input.split(",")) {
                numbers.add(Integer.parseInt(numberString));
            }
        } catch (NumberFormatException e) {
            throw new LottoInvalidException();
        }

        return new Lotto(numbers);
    }

    public Integer getBonusNumber(Lotto lotto) {
        while(true) {
            System.out.println(INPUT_BONUS_NUMBER_DESCRIPTION);
            String input = Console.readLine();
            try {
                return validateBonusNumberInput(input, lotto);
            } catch (IllegalArgumentException e) {
                exceptionController.printException(e);
            } finally {
                System.out.println();
            }
        }
    }

    private Integer validateBonusNumberInput(String input, Lotto lotto) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BonusNumberOutOfBoundException();
        }

        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new BonusNumberOutOfBoundException();
        }

        if(lotto.getNumbers().contains(bonusNumber)) {
            throw new BonusNumberDuplicateException();
        }

        return bonusNumber;
    }
}
