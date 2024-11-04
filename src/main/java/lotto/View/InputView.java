package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    public long inputPayment(){
        printPaymentMessage();
        String payment = Console.readLine();
        validateIsNumber(payment);
        return Long.parseLong(payment);
    }
    public List<Integer> inputWinningLottoNumber(){
        printWinningLottoNumber();
        String winningLottoNumber = Console.readLine();
        validateSeparator(winningLottoNumber);
        return convertStringToList(winningLottoNumber);
    }
    public int inputBonusNumber(){
        printBonusNumberMessage();
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
    private static void validateIsNumber(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }
    }
    public void validateSeparator(String input) {
        String REGEX = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";

        if (!Pattern.matches(REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 쉼표(,)로 구분하여 입력하세요.");
        }
    }
    public void validateBonusNumber(String input){
        validateIsNumber(input);
        validateNumberRange(Integer.parseInt(input));
    }
    public void validateNumberRange(int input){
        if(input < 1 || input > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하의 숫자만 가능합니다.");
        }
    }

    private void printWinningLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요");
    }
    private void printPaymentMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    private void printBonusNumberMessage(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
    private List<Integer> convertStringToList(String input){
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
