package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.Constants.Message;
import lotto.Constants.Error;
import lotto.Domain.LottoMachine;
import lotto.Lotto;
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
                LottoMachine.validatePurchaseAmount(amount);
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
            } catch (NoSuchElementException e) {
                System.out.println(Error.NO_SUCH_ELEMENT_EXCEPTION.getText());
            }
        }
    }

    public int getBonusNumber(Lotto playerLotto) {
        while (true) {
            try {
                String s = promptForInput(Message.BONUS_NUMBER.getText());
                int bonusNumber = NumberUtils.parseStringToInt(s);
                playerLotto.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(Error.NO_SUCH_ELEMENT_EXCEPTION.getText());
            }
        }
    }

    private List<Integer> parseLottoNumbers(String s) {
        String[] numbers = s.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            lottoNumbers.add(NumberUtils.parseStringToInt(number));
        }
        return lottoNumbers;
    }

    private String promptForInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

}
