package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNum {
    private static final int LOTTO_PRICE = 1000;
    private static final int CORRECT_3 = 5000;
    private static final int CORRECT_4 = 50000;
    private static final int CORRECT_5 = 1500000;
    private static final int CORRECT_BONUS_5 = 30000000;
    private static final int CORRECT_6 = 2000000000;

    private List<List<Integer>> lottos = new ArrayList<>();

    public LottoNum(int money) {
        checkMoney(money);
        lottoNumbers(money);
        printNumber(money);
    }

    private void checkMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
        }
    }

    private void lottoNumbers(int money) {
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortNumbers = numbers.stream().sorted().toList();
            lottos.add(sortNumbers);
        }
    }

    public void printNumber(int money) {
        System.out.println();
        System.out.println( (money/LOTTO_PRICE) + "개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(List<Integer> numbers, int bonus, int money) {
        int[] counts = new int[numbers.size()];
        for(List<Integer> lotto : lottos) {
            int count = resCount(lotto, numbers);
            resCounts(counts, count, lotto, bonus);
        }
        printRes(counts, money);
    }

    public int resCount(List<Integer> lotto, List<Integer> numbers) {
        int count = 0;
        for(Integer number : lotto) {
            if(numbers.contains(number)) {
                count++;
            }
        }
            return count;
    }

    public void resCounts(int[] counts, int count, List<Integer> lotto, int bonus) {
        if(count == 6){
            counts[4]++;
            return;
        }
        if(count == 5 && lotto.contains(bonus)) {
            counts[3]++;
            return;
        }
        if(count == 5){
            counts[2]++;
            return;
        }
        if(count == 4){
            counts[1]++;
            return;
        }
        if(count == 3){
            counts[0]++;
            return;
        }
    }

    private int rateResult(int[] counts){
        int sum = 0;
        sum += counts[0] * CORRECT_3;
        sum += counts[1] * CORRECT_4;
        sum += counts[2] * CORRECT_5;
        sum += counts[3] * CORRECT_BONUS_5;
        sum += counts[4] * CORRECT_6;
        return sum;
    }

    public void printRes(int[] counts, int money) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", counts[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", counts[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", counts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", counts[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", counts[4]);
        int sum = rateResult(counts);
        double sumResult = ((double)sum/money) * 100;
        sumResult = Math.round(sumResult * 100.0) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", sumResult);
    }
}