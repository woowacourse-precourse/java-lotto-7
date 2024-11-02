package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import util.NumberValidate;

public class Application {

    public static void main(String[] args) {
        LottoSeller lottoSeller;
        String inputCash;
        do {
            inputCash = getCashAmount();
        } while (!validateCashInput(inputCash));

        lottoSeller = new LottoSeller(Integer.parseInt(inputCash), Lotto.PRICE);
        List<Lotto> lottos = lottoSeller.sell();
        System.out.println(lottos.size() + GameMessage.GET_LOTTO_MESSAGE.getMessage());
        lottos.forEach(lotto -> System.out.println(lotto.getLottoNumber()));
        List<Integer> winningNumbers = getWinningNumbers();
        String inputBonusNumber;
        do {
            inputBonusNumber = getBonusNumber();
        } while (!validateBonusInput(inputBonusNumber, winningNumbers));
        System.out.println();
        System.out.println(GameMessage.RESULT_AVERAGE_MESSAGE.getMessage());
        System.out.println(GameMessage.RESULT_HYPE_MESSAGE.getMessage());
    }

    private static String getCashAmount() {
        System.out.println(GameMessage.GET_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    private static boolean validateCashInput(String inputCash) {
        if (!NumberValidate.isNumber(inputCash)) {
            System.out.println(ErrorMessage.PURCHASE_AMOUNT_INPUT_NOT_NUMBER.getMessage());
            return false;
        }

        if (!NumberValidate.isPositiveNumber(inputCash)) {
            System.out.println(ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE_NUMBER.getMessage());
            return false;
        }

        int cash = Integer.parseInt(inputCash);

        if (!NumberValidate.nothingLeftAfterDivideBy(cash, Lotto.PRICE)) {
            System.out.println(ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND.getMessage());
            return false;
        }
        return true;
    }

    private static List<Integer> getWinningNumbers() {
        final String INPUT_SEPARATOR = ",";
        Pattern pattern = Pattern.compile("[ ]*\\d+(?:[ ]*,[ ]*\\d+){5}");

        String inputWinningNumbers;
        do {
            System.out.println(GameMessage.GET_WINNING_NUMBER_MESSAGE.getMessage());
            inputWinningNumbers = Console.readLine();
        } while (!pattern.matcher(inputWinningNumbers).matches());

        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(INPUT_SEPARATOR, -1))
                .map(Integer::parseInt)
                .toList();
        return winningNumbers;
    }

    private static String getBonusNumber() {
        System.out.println(GameMessage.GET_BONUS_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

    private static boolean validateBonusInput(String inputBonusNumber, List<Integer> winningNumbers) {
        if (!NumberValidate.isNumber(inputBonusNumber)) {
            System.out.println(ErrorMessage.WINNING_NUMBER_NOT_NUMBER.getMessage());
            return false;
        }
        if (!NumberValidate.isPositiveNumber(inputBonusNumber)) {
            System.out.println(ErrorMessage.WINNING_NUMBER_NOT_POSITIVE_NUMBER.getMessage());
            return false;
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            return false;
        }
        return true;
    }
}
