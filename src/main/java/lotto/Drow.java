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

    private boolean validateDrowNumbers(String userInput){

        List<Integer> checkNumbers = new ArrayList<>(); // 중복 확인을 위한 숫자 리스트

        try {
            String[] inputNumbers = userInput.split(",");

            if(inputNumbers.length!=6){
                throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
            }

            for(String inputNumber : inputNumbers){

                int drowNumber = Integer.parseInt(inputNumber);
                validateInputNumber(drowNumber);
                validateDuplicationNumber(checkNumbers, drowNumber);
                checkNumbers.add(drowNumber);

            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            return false;

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return false;

        }


    }

    private boolean validateBonusNumber(String userInput){
        try{
            int bonusNumber = Integer.parseInt(userInput);

            validateInputNumber(bonusNumber);
            validateDuplicationNumber(drowNumbers, bonusNumber);

            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            return false;

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
            return false;

        }
    }

    private void validateInputNumber(int drowNumber){

        if (drowNumber < 1){
            throw new IllegalArgumentException("당첨 번호는 1보다 커야합니다.");
        }

        if (drowNumber > 45){
            throw new IllegalArgumentException("당첨 번호는 45보다 작아야합니다.");
        }

    }

    private void validateDuplicationNumber(List<Integer> checkNumbers, int drowNumber){

        for(int checkNumber : checkNumbers){

            if(checkNumber == drowNumber){
                throw new IllegalArgumentException("중복되는 당첨 번호가 있습니다");
            }

        }
    }




}
