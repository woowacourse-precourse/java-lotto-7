package lotto.handler;

import camp.nextstep.edu.missionutils.Console;

import static lotto.message.ErrorMessage.*;

public class MoneyInputHandler {
    public long getLottoCount(String inputNum) {
        while (true){
            try {
                long rawMoney = Long.parseLong(inputNum);
                return validateMoney(rawMoney);
            } catch (NumberFormatException e){
                System.out.println(NON_INTEGER_PURCHASE_AMOUNT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private long validateMoney(long rawMoney) {
        if (rawMoney < 0){
            throw new IllegalArgumentException(NEGATIVE_PURCHASE_AMOUNT.getMessage());
        }
        if (rawMoney % 1000 != 0){
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
        return rawMoney / 1000;
    }
}
