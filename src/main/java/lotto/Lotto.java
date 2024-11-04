package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    private void duplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }

    public void checkBonusDupl(int bonus, List<List<Integer>> lottoNumbers){
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복이 없어야 합니다.");
        }
    }

    public void getResult(int bonus, List<List<Integer>> lottoNumbers, int price){
        int[] result = new int[8];

        for (List<Integer> lottoNumber : lottoNumbers) {

            List<Integer> tempNumber = new ArrayList<>(lottoNumber);
            tempNumber.retainAll(numbers);

            int i = tempNumber.size();
            if(i == 5){
                i = i + checkBonus(lottoNumber, bonus);
            }

            if(i == 6){
                i +=1;
            }

            result[i]++;
        }

        printResult(result);
        printReturn(result, price);
    }

    private int checkBonus(List<Integer> lottoNumber, int bonus) {
        if (lottoNumber.contains(bonus)) {
            return 1;
        } else {
            return 0;
        }
    }

    private void printResult(int[] result) {
        String[] reward = {"개 일치 (5,000원) - ","개 일치 (50,000원) - ","개 일치 (1,500,000원) - ","개 일치, 보너스 볼 일치 (30,000,000원) - ","개 일치 (2,000,000,000원) - "};
        System.out.println(" ");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 3; i < result.length; i++) {
            if (i >= 6){
                System.out.println(i-1 + reward[i-3] + result[i] + "개");
            } else{
                System.out.println(i + reward[i-3] + result[i] + "개");
            }

        }
    }

    private void printReturn(int[] result, int price) {
        double returnprice = 0;
        int[] reward = {5000,50000,1500000,30000000,2000000000};
        for (int i = 3; i < result.length; i++) {
            returnprice += result[i] * reward[i-3];
        }
        returnprice = returnprice/price*100;
        System.out.println("총 수익률은 "+ returnprice + "%입니다.");
    }
}
