package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import lotto.Constants.Message;
import lotto.Constants.Error;
import lotto.Utils.NumberUtils;

public class InputView {
    /**
     * 로또 구입 금액을 입력받는 메서드
     *
     * @return 로또 구입 금액
     */
    public int getLottoPurchaseAmount() {
        while (true) {
            try {
                String s = promptForInput(Message.PURCHASE_AMOUNT.getText());
                int amount = NumberUtils.parseStringToInt(s);
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(Error.NO_SUCH_ELEMENT_EXCEPTION.getText());
            }
        }
    }

    public List<Integer> getLottoNumbers() {
        while (true) {
            try {
                String s = promptForInput(Message.LOTTO_NUMBERS.getText());
                return parseLottoNumbers(s);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(Error.NO_SUCH_ELEMENT_EXCEPTION.getText());
            }
        }
        return lottoNumbers;
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_LT_MINIMUM.getText());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getText());
        }
    }

    private static String promptForInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

}
