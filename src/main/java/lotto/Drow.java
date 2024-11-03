package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Drow {

    List<Integer> drowNumbers = new ArrayList<>(); // 당첨 번호
    Integer bonusNumber; // 보너스 번호

    /// 당첨 번호 입력
    public void inputDrowNumbers(){

        String userInput;

        while(true){
            System.out.println("당첨 번호를 입력해 주세요.");
            userInput = Console.readLine(); // 유저로부터 입력받은 금액을 저장
            userInput = userInput.trim();

            if(validateDrowNumbers(userInput)) break; // 유효한 값을 입력받을때까지 반복
        }

        String[] inputNumbers = userInput.split(",");

        for(String inputNumber : inputNumbers){
            drowNumbers.add(Integer.parseInt(inputNumber)); // 당첨번호 배열에 저장
        }
    }

    ///보너스 번호 입력
    public void inputBonusNumber(){

        String userInput;

        while(true){

            System.out.println("보너스 번호를 입력해 주세요.");
            userInput = Console.readLine(); // 유저로부터 입력받은 금액을 저장
            userInput = userInput.trim();

            if(validateBonusNumber(userInput)) break;
        }

        bonusNumber = Integer.parseInt(userInput);
    }

    boolean validateDrowNumbers(String userInput){
        return true;
    }

    boolean validateBonusNumber(String userInput){
        return true;
    }


}
