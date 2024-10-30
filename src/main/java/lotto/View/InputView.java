package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ASK_PurchaseAmount="구입금액을 입력해 주세요.";
    private static final String ASK_WinningNumber="당첨 번호를 입력해 주세요.";
    private static final String ASK_BounsNumber="보너스 번호를 입력해 주세요.";
    private static final String ERROR_PurchaseAmount="[ERROR] 구입 금액은 양수인 1000원 단위로 입력해주세요.";
    private static final String ERROR_RangeValidWinningNumber="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_CommaValidWinningNumber="[ERROR] 당첨 번호는 쉼표로 구분되어야 합니다.";
    private static final String ERROR_OverlapValidWinningNumber="[ERROR] 당첨 번호는 중복된 숫자일 수 없습니다.";
    private static final String ERROR_RangeValidBounsNumber="[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";


    public static int input_purchaseAmount() {
        while (true) {
            System.out.println(ASK_PurchaseAmount);
            String input_purchase_amount = readLine();
            if (isValidAmount(input_purchase_amount)) return parsePurchaseAmount(input_purchase_amount);
            ErrorInvalidAmount();
        }
    }
    public static List<Integer> input_winningNumber() {
        while (true) {
            System.out.println(ASK_WinningNumber);
            String input_winning_number = readLine();
            if (!isRangeValidWinningNumber(input_winning_number)){
                ErrorRangeValidWinningNumber();
                continue;
            }
            if(!isCommaWinngingnumber(input_winning_number)){
                ErrorCommaValidWinningNumber();
                continue;
            }
            if(!isOverlapWinningnumber(input_winning_number)){
                ErrorOverlapValidWinningNumber();
                continue;
            }
            return parseWinningNumbers(input_winning_number);
        }
    }
    public static int input_bounsNumber() {
        while (true) {
            System.out.println(ASK_BounsNumber);
            String input_bouns_number = readLine();
            if(isRangeBounsNumber(input_bouns_number)) return parseBounsNumber(input_bouns_number);
            ErrorRangeValidBounsNumber();
        }
    }
    private static boolean isRangeBounsNumber(String input_bouns_number) {
        int bounsNumber = parseBounsNumber(input_bouns_number);
        if(bounsNumber < 1 || bounsNumber > 45) return false;
        return true;
    }
    private static boolean isRangeValidWinningNumber(String input_winning_number) {
        String[] winning_number=input_winning_number.split(",");
        for(String number:winning_number){
            int valid_number=Integer.parseInt(number.trim());
            if(valid_number<1||valid_number>45) return false;
        }
        return true;
    }
    private static boolean isOverlapWinningnumber(String input_winning_number) {
        Set<Integer> winning_number_set = new HashSet<>();
        String[] winning_numbers = input_winning_number.split(",");
        for (String number : winning_numbers) {
            int valid_number = Integer.parseInt(number.trim());
            if (!winning_number_set.add(valid_number)) return false;
        }
        return true;
    }
    private static boolean isCommaWinngingnumber(String input_winning_number) {
        if(!input_winning_number.contains(",")) return false;
        return true;
    }
    private static void ErrorRangeValidBounsNumber() {
        throw new IllegalThreadStateException(ERROR_RangeValidBounsNumber);
    }
    private static void ErrorRangeValidWinningNumber() {
        throw new IllegalArgumentException(ERROR_RangeValidWinningNumber);
    }
    private static void ErrorCommaValidWinningNumber() {
        throw new IllegalArgumentException(ERROR_CommaValidWinningNumber);
    }
    private static void ErrorOverlapValidWinningNumber() {
        throw new IllegalArgumentException(ERROR_OverlapValidWinningNumber);
    }
    private static void ErrorInvalidAmount(){
        throw new IllegalArgumentException(ERROR_PurchaseAmount);
    }
    private static boolean isValidAmount(String input_purchase_amount) {
        return check_invalidAmount(input_purchase_amount);
    }
    private static List<Integer> parseWinningNumbers(String input_winning_number) {
        String[] numbers = input_winning_number.split(",");
        return List.of(numbers).stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
    private static int parsePurchaseAmount(String input_purchase_amount) {
        return Integer.parseInt(input_purchase_amount);
    }
    private static int parseBounsNumber(String input_bouns_number) {
        return Integer.parseInt(input_bouns_number);
    }
    private static boolean check_invalidAmount(String purchase_amount){
        int amount=Integer.parseInt(purchase_amount);
        if(amount%1000==0&&amount>0) return true;
        return false;
    }
}
