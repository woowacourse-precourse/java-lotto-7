package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static int budget;
    public static int numberOfLotto;
    public static ArrayList<Lotto> lottos;
    public static Lotto goals;
    public static int bonusNumber;
    public static int[] statistics;

    public static List<Integer> makeLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void inputBudget(){
        System.out.println("구입금액을 입력해 주세요.");
        while(true){
            try {
                budget = Integer.parseInt(Console.readLine());
                validateBudget();
                break;
            } catch (NumberFormatException e){
                System.out.println("[ERROR] 구입 금액은 숫자만 입력해야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void validateBudget(){
        if (budget < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    public static void calculateNumberOfLotto(){
        numberOfLotto = budget/1000;
        System.out.println();
        System.out.println(numberOfLotto+"개를 구매했습니다.");
    }

    public static void pickNumbers(){
        lottos = new ArrayList<>();
        for(int i=0;i<numberOfLotto;i++){
            lottos.add(new Lotto(makeLotto()));
            System.out.println(lottos.get(i).toString());
        }
        System.out.println();
    }

    public static void inputGoals(){
        System.out.println("당첨 번호를 입력해 주세요.");
        while(true){
            try {
                validateGoals();
                break;
            } catch(NumberFormatException e){
                System.out.println("[ERROR] 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void validateGoals(){
        List<Integer> goalNumbers = new ArrayList<>();
        for (String number : Console.readLine().split(",")) {
            goalNumbers.add(Integer.parseInt(number.trim()));
        }
        goals = new Lotto(goalNumbers);
    }

    public static void inputBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        while(true){
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusDuplicate(goals,bonusNumber);
                validateNumberRange(bonusNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
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

    public static void printResult(){
        statistics = new int[6];
        for(Lotto lotto : lottos){
            Rank rank = lotto.getRank(goals, bonusNumber);
            statistics[rank.ordinal()]++;
        }
        printStatistics();
        printProfitRate();
    }

    public static void printStatistics(){
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+statistics[Rank.FIFTH.ordinal()]+"개");
        System.out.println("4개 일치 (50,000원) - "+statistics[Rank.FOURTH.ordinal()]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+statistics[Rank.THIRD.ordinal()]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+statistics[Rank.SECOND.ordinal()]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+statistics[Rank.FIRST.ordinal()]+"개");
    }

    public static int calculateProfit(){
        return (Rank.FIRST.getPrize()*statistics[Rank.FIRST.ordinal()]
                +Rank.SECOND.getPrize()*statistics[Rank.SECOND.ordinal()]
                +Rank.THIRD.getPrize()*statistics[Rank.THIRD.ordinal()]
                +Rank.FOURTH.getPrize()*statistics[Rank.FOURTH.ordinal()]
                +Rank.FIFTH.getPrize()*statistics[Rank.FIFTH.ordinal()]);
    }

    public static void printProfitRate(){ // 수익률 = (당첨금액/구입금액)*100
        int profit = calculateProfit();
        double profitRate = (double) profit / budget * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }

    public static void main(String[] args) {
        // 1. 구매 금액 입력
        inputBudget();

        // 2. 구매 개수 계산
        calculateNumberOfLotto();

        // 3. 로또 번호 뽑기
        pickNumbers();

        // 4. 당첨 번호 입력
        inputGoals();

        // 5. 보너스 번호 입력
        inputBonus();

        // 6. 등수 계산 및 출력
        printResult();
    }
}
