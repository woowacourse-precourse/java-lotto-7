package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public static int inputPurchaseAmount() throws IllegalArgumentException {
        int puschaseAmount;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            puschaseAmount = Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수로 입력해야 합니다.");
        }
        validatePurchaseAmount(puschaseAmount);
        return puschaseAmount;
    }

    public static void validatePurchaseAmount(int purchaseAmount){
        if((purchaseAmount % 1000) != 0 && (purchaseAmount / 1000) < 1){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000 이상의, 1000단위 정수로 입력해야 합니다");
        }
    }

    public static int calculateLottoAmount(int purchaseAmount){
        return purchaseAmount/1000;
    }

    public static List<Integer> inputWinnerNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String winningNumbersInString = Console.readLine();
            return Arrays.stream(winningNumbersInString.split(",")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
    
    public static int inputBonusNumber(List<Integer> winningNumbers) throws IllegalArgumentException{
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;
        try{
            bonusNumber = Integer.parseInt(Console.readLine());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수로 입력해야 합니다.");
        }
        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) throws IllegalArgumentException{
        if(bonusNumber < 1 && bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 내에 있는 정수입니다.");
        }
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존 당첨번호와 중복될 수 없습니다.");
        }
    }
}