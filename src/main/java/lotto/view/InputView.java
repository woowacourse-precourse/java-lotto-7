package lotto.view;

import static lotto.common.ExceptionMessage.CONVERSION_ERROR_MESSAGE;
import static lotto.common.ExceptionMessage.DUPLICATION_ERROR_MESSAGE;
import static lotto.common.ExceptionMessage.ERROR_PHRASE;
import static lotto.common.ExceptionMessage.NOT_INTEGER_ERROR_MESSAGE;
import static lotto.common.ExceptionMessage.RANGE_ERROR_MESSAGE;
import static lotto.common.ExceptionMessage.SIZE_ERROR_MESSAGE;
import static lotto.common.ExceptionMessage.UNDER_ZERO_ERROR_MESSAGE;
import static lotto.common.ExceptionMessage.UNITS_ERROR_MESSAGE;
import static lotto.common.LottoConstant.MAX_NUMBER;
import static lotto.common.LottoConstant.MIN_NUMBER;
import static lotto.common.LottoConstant.TICKET_MIN_UNITS;
import static lotto.common.LottoConstant.TICKET_SIZE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoPurchase;

public class InputView {
    private final String INFO_BUY_PRICE="구입금액을 입력해 주세요.";
    private final String INFO_LOTTO_ANSWER = "\n당첨 번호를 입력해 주세요.";
    private final String INFO_LOTTO_BONUS = "\n보너스 번호를 입력해 주세요.";
    public LottoPurchase getLottoTicketPurchase(){
        while(true){
            try {
                System.out.println(INFO_BUY_PRICE);
                String priceInput = Console.readLine();
                int price = validateInteger(priceInput);
                return new LottoPurchase(price);
            } catch (IllegalArgumentException e){
                System.out.println(ERROR_PHRASE + e.getMessage());
            }
        }
    }

    private int validateInteger(String string){
        try {
            int number = Integer.parseInt(string);
            checkValidate(number);
            return number;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(String.format(NOT_INTEGER_ERROR_MESSAGE, string));
        }
    }

    private void checkValidate(int number){
        if(number<=0){
            throw new IllegalArgumentException(UNDER_ZERO_ERROR_MESSAGE);
        } else if (number % TICKET_MIN_UNITS != 0){
            throw new IllegalArgumentException(UNITS_ERROR_MESSAGE);
        }
    }

    public List<Integer> getLottoAnswer(){
        while(true){
            try {
                System.out.println(INFO_LOTTO_ANSWER);
                String input = Console.readLine();
                return getWinningNumbers(input);
            }catch (IllegalArgumentException e){
                System.out.println(ERROR_PHRASE + e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers(String input) {
        String[] inputNumbers = input.split(",");
        if(inputNumbers.length != TICKET_SIZE){
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
        Set<Integer> numbers = new HashSet<>();
        for (String number : inputNumbers) {
            validateNumber(number, numbers);
        }
        return new ArrayList<>(numbers); // 유효한 번호 리스트 반환

    }

    private void validateNumber(String input, Set<Integer> numbers) {
        try {
            int num = Integer.parseInt(input.trim());
            if (num < MIN_NUMBER || num > MAX_NUMBER) {
                throw new IllegalArgumentException(String.format(RANGE_ERROR_MESSAGE, num));
            }
            if (!numbers.add(num)) {
                throw new IllegalArgumentException(String.format(DUPLICATION_ERROR_MESSAGE, num));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(CONVERSION_ERROR_MESSAGE, input));
        }
    }

    public Integer getBonusNumber(List<Integer> winningNumbers){
        while(true){
            try {
                System.out.println(INFO_LOTTO_BONUS);
                String input = Console.readLine();
                return validateBonus(input, winningNumbers);
            } catch (IllegalArgumentException e){
                System.out.println(ERROR_PHRASE + e.getMessage());
            }
        }
    }

    private int validateBonus(String input, List<Integer> winningNumbers){
        try {
            int bonus = Integer.parseInt(input.trim());
            if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
                throw new IllegalArgumentException(String.format(RANGE_ERROR_MESSAGE, bonus));
            }
            if (winningNumbers.contains(bonus)) {
                throw new IllegalArgumentException(String.format(DUPLICATION_ERROR_MESSAGE, bonus));
            }
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(CONVERSION_ERROR_MESSAGE, input));
        }
    }

}
