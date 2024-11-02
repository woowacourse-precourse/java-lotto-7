package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputUtil {
    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_NUMBER_ERROR = "[ERROR] 입력값은 자연수여야 합니다.";
    private static final String INPUT_UNDER_ERROR = "[ERROR] 구입 금액은 1,000원 이상이어야 합니다.";
    private static final String INPUT_UNIT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String INPUT_FORMAT_ERROR = "[ERROR] 입력 형식이 올바르지 않습니다. 번호는 쉼표(,)로 구분하여 6개를 입력해야 합니다.";
    private static final String INPUT_RANGE_ERROR = "[ERROR] 모든 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_DUPLICATE_ERROR = "[ERROR] 중복된 번호가 있습니다.";
    private static final int MIN_LOTTO_PRICE = 1000;

    public static int getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT);
        String inputMoney = Console.readLine();
        checkValidPurchaseAmount(inputMoney);
        return convertToInt(inputMoney);
    }

    public static int getLottoCount(int purchaseAmount){
        return purchaseAmount/MIN_LOTTO_PRICE;
    }

    public static List<Integer> getWinningNumbers(){
        System.out.println("\n"+WINNING_NUMBERS_INPUT);
        String input = Console.readLine();
        return parseWinningNumbers(input);
    }

    public static List<Integer> parseWinningNumbers(String input){
        String[] tokens = splitInput(input);
        validateNumberCount(tokens);
        return parseAndValidateNumbers(tokens);
    }

    private static List<Integer> parseAndValidateNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        for(String token : tokens){
            validateNumeric(token);
            validateNumberRange(token);
            int number = convertToInt(token);
            validateUniqueNumber(number, uniqueNumbers);
            numbers.add(number);
        }
        return numbers;
    }

    private static void validateUniqueNumber(int number, Set<Integer> uniqueNumbers){
        if(!uniqueNumbers.add(number)){
            throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR);
        }
    }

    private static void validateNumberCount(String[] tokens) {
        if(tokens.length != 6){
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
        }
    }

    private static String[] splitInput(String input){
        return input.split(",");
    }

    private static void validateNumberRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException( INPUT_RANGE_ERROR);
        }
    }

    private static void checkValidPurchaseAmount(String input){
        validateNumeric(input);
        validateMinimumAmount(input);
        validateUnit(input);
    }

    private static void validateUnit(String input) {
        if(Integer.parseInt(input) % MIN_LOTTO_PRICE  != 0){
            throw new IllegalArgumentException(INPUT_UNIT_ERROR);
        }
    }

    private static void validateMinimumAmount(String input) {
        if(Integer.parseInt(input)< MIN_LOTTO_PRICE){
            throw new IllegalArgumentException(INPUT_UNDER_ERROR);
        }
    }

    private static void validateNumeric(String input) {
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
    }

    private static int convertToInt(String input){
        return Integer.parseInt(input);
    }
}
