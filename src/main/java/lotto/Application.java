package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int[] statistics;
    public static int budget;
    public static int numberOfLotto;

    public static List<Integer> makeLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void printStatistics(){
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+statistics[5]+"개");
        System.out.println("4개 일치 (50,000원) - "+statistics[4]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+statistics[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+statistics[2]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+statistics[1]+"개");
    }

    public static int calculateProfit(){
        return (2000000000*statistics[1]
                +30000000*statistics[2]
                +1500000*statistics[3]
                +50000*statistics[4]
                +5000*statistics[5]);
    }

    public static void printProfitRate(){ // 수익률 = (당첨금액/구입금액)*100
        int profit = calculateProfit();
        double profitRate = (profit / budget) * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.", profitRate);
    }

    public static void validateBonusDuplicate(Lotto goals, int bonus){
        if(goals.getNumbers().contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다.");
        }
    }

    public static void validateNumberRange(int bonus){
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    public static void main(String[] args) {
        // 1. 구매 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        try {
            budget = Integer.parseInt(Console.readLine());
            if (budget < 1000) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력해야 합니다.");
        }

        // 2. 구매 개수 계산
        numberOfLotto = budget/1000;
        System.out.println();
        System.out.println(numberOfLotto+"개를 구매했습니다.");

        // 3. 로또 번호 뽑기
        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<numberOfLotto;i++){
            lottos.add(new Lotto(makeLotto()));
            System.out.println(lottos.get(i).toString());
        }
        System.out.println();

        // 4. 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> goalNumbers = new ArrayList<>();
        try {
            for (String number : Console.readLine().split(",")) {
                goalNumbers.add(Integer.parseInt(number.trim()));
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
        }
        System.out.println();
        Lotto goals = new Lotto(goalNumbers);

        // 5. 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;
        try {
             bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        validateBonusDuplicate(goals,bonusNumber);
        validateNumberRange(bonusNumber);
        System.out.println();

        // 6. 등수 계산 및 출력
        statistics = new int[6];
        for(Lotto lotto : lottos){
            int rank = lotto.getRank(goals,bonusNumber);
            statistics[rank]++;
        }
        printStatistics();
        printProfitRate();
    }
}
