package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLottoNumbers {
    public int[] countPrize = new int[6];
    public MakeLottoNumbers(){
        this.countPrize = new int[6]; // 초기화
        makeLottoNumber();

    }
    public void makeLottoNumber() {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        List<Integer> lotto = new ArrayList<>();
        List<Integer> prize = new ArrayList<>();
        int count = inputMoney();
        System.out.println(count+"개를 구매했습니다.");

        for (int i = 0; i < count; i++) {
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 로또 번호 입력받기
            allLottoNumbers.add(lotto);
            sortLottoNumbers(lotto);
            printLottoNumbers(lotto);
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        prize = Lotto.lottoNumber(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        validate(prize, bonus);
        /*for (List<Integer> lottos: allLottoNumbers) {
            matchLottoNumbers(lottos,prize,bonus);
        }*/
        for(int i = 0; i<allLottoNumbers.size(); i++){
            matchLottoNumbers(allLottoNumbers.get(i), prize, bonus);
        }
        calculate(countPrize, count);
    }
    private List<Integer> sortLottoNumbers(List<Integer> lotto) {
        List<Integer> numbers = new ArrayList<>(lotto);
        Collections.sort(numbers);

        return numbers;
    }

    public void validate(List<Integer> prize, int bonus){
        for(int i=0;i<6;i++){
            if(prize.get(i).equals(bonus)){
                System.out.print(prize.get(i)+" ");
                throw new IllegalArgumentException("[ERROR] 보너스 숫자가 될 수 없는 수 입니다.");
            }
        }
        if(bonus>45)
        {                throw new IllegalArgumentException("[ERROR] 보너스 숫자가 될 수 없는 수 입니다.");
        }
        if(bonus<0){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 될 수 없는 수 입니다.");
        }

    }
    private int inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        String input = null;
        input = Console.readLine();
        try {
            int money = Integer.parseInt(input); // 숫자로 변환 후 계산
            if (money < 1000) {
                System.out.println("[ERROR] 최소 1000원 이상의 금액을 입력해야 합니다.");
                return inputMoney();
            }
            if (money % 1000 != 0) {
                System.out.println("[ERROR] 1000원 단위의 금액을 입력해야 합니다.");
                System.out.println(money% 1000);
                return inputMoney();
            }
            return money / 1000;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            return inputMoney();
        }
    }

    private void printLottoNumbers(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if (i < lotto.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int[] matchLottoNumbers(List<Integer> numbers, List<Integer> lotto, int bonusNumber) {
        int count = 0;
        boolean bonus = false;
        for(Integer number : numbers){
            if(lotto.contains(number)){
                count++;
            }
        }
        if(numbers.contains(bonusNumber)) {
            bonus = true;
        }
        countPrizes(countPrize, count, bonus);
        return countPrize;
    }
    public void calculate(int[] countPrize, int count){
        System.out.println("당첨 통계");
        System.out.println("---");
        int sum = 0;
        for (int i=0; i<6; i++) {
            Money rank = Money.values()[i];
            if (rank.isBonus() && rank.getMatchedCount() == 5) {
                System.out.println(rank.getMatchedCount() + "개 일치, 보너스 볼 일치 (" + formatNumber(rank.getPrize()) + "원) - " + countPrize[i] + "개");
                sum += countPrize[i] * rank.getPrize();
            }
            if (!rank.isBonus()) {
                System.out.println(rank.getMatchedCount() + "개 일치 (" + formatNumber(rank.getPrize()) + "원) - " + countPrize[i] + "개");
                sum += countPrize[i] * rank.getPrize();
            }
        }
        double prize = ((double) sum / (count*10));
        prize = Math.round(prize * 10.0) / 10.0;
        System.out.println("총 수익률은 "+prize+"%입니다.");
        //비율 이상한거면 에러처리
    }

    public int[] countPrizes(int[] countPrize, int count, boolean bonus){
        first(countPrize, count, bonus);
        bonus(countPrize, count, bonus);
        if(count<3) {
            countPrize[0]++;
        }
        return countPrize;
    }

    public int[] first(int[] countPrize, int count, boolean bonus) {
        if(count == 6){
            countPrize[5]++;
            return countPrize;
        }
        if(count == 4){
            countPrize[2]++;
            return countPrize;
        }
        if(count == 3){
            countPrize[1]++;
            return countPrize;
        }
        return countPrize;
    }

    public int[] bonus(int[] countPrize, int count, boolean bonus) {
        if(count == 5&&bonus){
            countPrize[4]++;
            return countPrize;
        }
        if(count == 5&&!bonus) {
            countPrize[3]++;
        }
        return countPrize;
    }
    private String formatNumber(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }

}
