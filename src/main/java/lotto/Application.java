package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public int divideByThousand(String input) {
        try{
            isNumeric(input);
            checkAmountWithinRange(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("다시 입력해 주세요.");
            return divideByThousand(Console.readLine());
        }
        return Integer.parseInt(input) / 1000;
    }

    public void isNumeric(String input){
        if(!input.matches("[0-9]+$")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    public void checkAmountWithinRange(String input){
        if (Integer.parseInt(input) % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.");
        }
    }

    public String requestPurchaseAmountInput(){
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public ArrayList<List<Integer>> generateLottoNumbers(int times){
        System.out.println(times + "개를 구매했습니다.");
        ArrayList<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            List<Integer> purchasedLottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(purchasedLottoNumber);
            purchasedLottoNumbers.add(purchasedLottoNumber);
        }
        printLottoNumbers(purchasedLottoNumbers);
        return purchasedLottoNumbers;
    }
    public void printLottoNumbers(ArrayList<List<Integer>> purchasedLottoNumbers){
        for (List<Integer> purchasedLottoNumber : purchasedLottoNumbers) {
            System.out.println(purchasedLottoNumber);
        }
    }
    public String requestLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String [] splitNumbers(String input){
        return input.split(",");
    }

    public Lotto generateLotto(String input){
        Lotto lotto;
        List<Integer> numbers = new ArrayList<>();
        try{
            for(String i : splitNumbers(input)){
                isNumeric(i);
                isNumberBetween1And45(Integer.parseInt(i));
                numbers.add(Integer.parseInt(i));
            }
            lotto = new Lotto(numbers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("다시 입력해 주세요.");
            return generateLotto(Console.readLine());
        }
        return lotto;
    }

    public String requestBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void isNumberBetween1And45(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public void checkForDuplicates(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되어선 안됩니다.");
        }
    }

    


    public static void main(String[] args) {
        Application application = new Application();
        application.generateLottoNumbers(application.divideByThousand(application.requestPurchaseAmountInput()));
    }
}
