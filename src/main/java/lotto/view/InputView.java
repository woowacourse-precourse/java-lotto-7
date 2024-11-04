package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoRound;
import lotto.validator.InputValidator;
import lotto.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;

import static lotto.model.enums.ErrorMessage.ERROR_INVALID_INPUT_FORMAT;

public class InputView {

    static final String INPUT_ORDER_PRICE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    static final int LOTTO_PRICE = 1000;

    public static String inputOrderPrice() {
        System.out.println(INPUT_ORDER_PRICE);
        return Console.readLine();
    }

    public static String inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public static int parseOrder(String inputOrderPrice){
        try {
            InputValidator.validateOrderPrice(inputOrderPrice);
            int orderPrice = Integer.parseInt(inputOrderPrice);
            return orderPrice / LOTTO_PRICE;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_INVALID_INPUT_FORMAT.getMessage());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static List<Integer> parseWinningNumber(String inputWinningNumber){
        try {
            List<Integer> numbers = Arrays.stream(inputWinningNumber.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            LottoValidator.validateLottoNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_INVALID_INPUT_FORMAT.getMessage());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int parseBonusNumber(String inputBonusNumber, LottoRound lottoRound) {
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            LottoValidator.validateBonusNumber(bonusNumber, lottoRound.getWinningLotto());
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_INVALID_INPUT_FORMAT.getMessage());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
