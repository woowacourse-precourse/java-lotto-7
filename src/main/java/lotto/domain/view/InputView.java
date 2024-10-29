package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.exception.BusinessException;

import static lotto.common.constant.LottoConst.*;
import static lotto.common.exception.ErrorCode.*;

public class InputView {

    public int getUserPurchaseAmount() {
        printRequestAmount();
        return readValidAmount();
    }

    private void printRequestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private int readValidAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                return validateAmount(input);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAmount(String input) {
        int amount = parseAmount(input);
        validateDivisibleByLottoPrice(amount);
        return amount;
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BusinessException(NOT_NUMBER);
        }
    }

    private void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new BusinessException(CANT_DIVIDE);
        }
    }
}