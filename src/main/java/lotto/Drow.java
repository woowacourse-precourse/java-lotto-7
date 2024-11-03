package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;



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

    boolean validateBonusNumber(String userInput){
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

    void validateInputNumber(int drowNumber){

        if (drowNumber < 1){
            throw new IllegalArgumentException("당첨 번호는 1보다 커야합니다.");
        }

        if (drowNumber > 45){
            throw new IllegalArgumentException("당첨 번호는 45보다 작아야합니다.");
        }

    }

    void validateDuplicationNumber(List<Integer> checkNumbers, int drowNumber){

        for(int checkNumber : checkNumbers){

            if(checkNumber == drowNumber){
                throw new IllegalArgumentException("중복되는 당첨 번호가 있습니다");
            }

        }
    }

    public void drowLotto(List<Lotto> lottos){

        for(Lotto lotto : lottos){
            compareNumber(lotto);
        }


    }

    private void compareNumber(Lotto lotto){

        List<Integer> numbers = lotto.getNumbers(); // 로또 별 번호 정보를 받아옴
        Set<Integer> numbersSet = new HashSet<>(numbers); // Set의 contains를 이용하여 일치하는 갯수 확인
        int validCount = 0;
        boolean bonus = false;

        for(Integer drowNumber : drowNumbers){

            if(numbersSet.contains(drowNumber)){
                validCount++;
            }

            if(numbersSet.contains(bonusNumber)){
                bonus = true;
            }

        }

        getPrize(validCount, bonus);
    }

    private void getPrize(int validCount, boolean bonus){

        if(validCount == 6){
            Prize.First.increaseCount();
        }
        if(validCount == 5 && bonus){
            Prize.Second.increaseCount();
        }
        if(validCount == 5 && !bonus){
            Prize.Third.increaseCount();
        }
        if(validCount == 4){
            Prize.Fourth.increaseCount();
        }
        if(validCount == 3){
            Prize.Fifth.increaseCount();
        }

    }

}
