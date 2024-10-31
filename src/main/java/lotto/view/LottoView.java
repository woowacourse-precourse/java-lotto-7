package lotto.view;

import lotto.model.Lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class LottoView {


    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR]";



    public int inputPurchaseAmountProcess() {
        while (true) {
            try {
                int purchaseAmount = inputAndValidateNumberForm();
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println(ERROR_MESSAGE + " " + "1000으로 나누어 떨어지는 자연수를 입력해 주세요.");
            }
        }
    }

    public int inputAndValidateNumberForm() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    private static void validatePurchaseAmount(int purchaseAmount) {

        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }

    }


}
