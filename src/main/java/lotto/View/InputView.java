package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
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
    }

    public int getBonusNumber(List<Integer> lottoNumbers) {
        while (true) {
            try {
                String s = promptForInput(Message.BONUS_NUMBER.getText());
                int bonusNumber = NumberUtils.parseStringToInt(s);
                validateBonusNumber(bonusNumber, lottoNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(Error.NO_SUCH_ELEMENT_EXCEPTION.getText());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_LT_MINIMUM.getText());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getText());
        }
    }

    private List<Integer> parseLottoNumbers(String s) {
        String[] numbers = s.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            lottoNumbers.add(NumberUtils.parseStringToInt(number));
        }
        validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    /**
     * 로또 번호 유효성 검사
     * 1. 6개의 숫자로 이루어져 있어야 한다.
     * 2. 중복된 숫자가 없어야 한다.
     * 3. 각 숫자는 1부터 45 사이여야 한다.
     *
     * @param numbers 로또 번호 리스트
     */
    private void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBERS_SIZE_NOT_6.getText());
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBERS_DUPLICATED.getText());
        }
        numbers.forEach(this::numberInRange);
    }

    private void numberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBERS_OUT_OF_RANGE.getText());
        }
    }

    /**
     * 보너스 번호 유효성 검사
     * 1. 로또 번호 리스트에 포함되어 있으면 안된다.
     * 2. 1부터 45 사이여야 한다.
     *
     * @param bonusNumber 보너스 번호
     * @param lottoNumbers 로또 번호 리스트
     */
    private void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBERS_DUPLICATED.getText());
        }
        numberInRange(bonusNumber);
    }

    private String promptForInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

}
