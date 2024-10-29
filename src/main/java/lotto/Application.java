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
            divideByThousand(Console.readLine());
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

    public String [] Lotto(String input){
        return input.split(",");
    }

    

    public static void main(String[] args) {
        Application application = new Application();
        application.generateLottoNumbers(application.divideByThousand(application.requestPurchaseAmountInput()));
    }
}
