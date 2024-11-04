package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.util.Validator;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    public static int getPurchaseAmount(){
        try{
            System.out.println(PURCHASE_AMOUNT_INPUT);
            String input = Console.readLine();
            Validator.validatePurchaseAmount(input);
            return convertToInt(input);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getPurchaseAmount();
        }
    }

    public static List<Integer> getWinningNumbers(){
        try{
            System.out.println("\n"+WINNING_NUMBERS_INPUT);
            String input = Console.readLine();
            List<Integer> winningNumbers = List.of(input.split(","))
                            .stream().map(number -> Integer.parseInt(number.trim())).collect(Collectors.toList());
            Validator.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers){
        try{
            System.out.println("\n"+BONUS_NUMBER_INPUT);
            String input = Console.readLine();
            Validator.validateBonusNumber(input, winningNumbers);
            return convertToInt(input);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] "+ e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private static int convertToInt(String input){
        return Integer.parseInt(input);
    }
}
