package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<List<Integer>> lottoNumbers = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private int bonus;
    private int price;

    public void getPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        this.price = Integer.parseInt(Console.readLine());
        int count = checkPrice(price);
        RandomNumber(count);

        inputNumber(); // -> numbers로 값 전송
        inputBonus();
    }

    private int checkPrice(int price){
        if(price%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        } else {
            int count = price/1000;
            System.out.println(" ");
            System.out.println(count+"개를 구매했습니다.");
            return count;
        }
    }

    private void RandomNumber(int count) {

        for (int i = 0; i < count; i++) {
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1,45,6));
        }
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    private void inputNumber(){
        System.out.println(" ");
        System.out.println("당첨 번호를 입력해 주세요.");
        String tempNum = Console.readLine();
        String[] temp = tempNum.split(",");
        for(String num : temp){
            numbers.add(Integer.parseInt(num));
        }
    }

    private void inputBonus(){
        System.out.println(" ");
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonus = Integer.parseInt(Console.readLine());
    }

    public List<Integer> getNumber(){
        return numbers;
    }

    public int getBonus(){
        return bonus;
    }

    public List<List<Integer>> getLottoNumbers(){
        return lottoNumbers;
    }

    public int gotPrice(){
        return price;
    }
}
