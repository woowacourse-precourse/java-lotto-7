package lotto;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int one_ticket = 1000;
    public static final int numSize = 6;
    public static int bonus;
    public static int bonusCount = 0;
    public static int[] amoutAry;
    public static List<Integer> winning_number;
    public static List<Integer>[] lotto_list;
    public static final int amount[] = {5000,50000,1500000,2000000000,30000000};
    public static final String amountPrint[] = {"5,000","50,000","1,500,000","2,000,000,000","30,000,000"};
    public enum PrintMsg {
        INPUT_MSG("구입금액을 입력해 주세요."),
        CHECK_MSG("개를 구매했습니다."),
        WINNING_NUM_MSG("당첨 번호를 입력해 주세요."),
        BONUS_NUM_MSG("보너스 번호를 입력해 주세요."),
        STATISTIC_MSG("당첨 통계"),
        ERROR_MSG("[ERROR] 정수 값으로 입력을 해야합니다."),
        REVENUE_MSG("총 수익률은 %d%%입니다."),
        MATCH_MSG("%d개 일치 (%s원) - %d개\n"),
        BONUS_MSG("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
        REVENUE("총 수익률은 %.1f%%입니다.");

        private final String message;

        PrintMsg(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application ap = new Application();
        ap.logic();
    }
    public void logic(){
        int num = purchase_amount();
        initialLottoArray(num);
        purchase_history(num);
        inputWinningNumber();
        inputBonus();
        matchCount();
        winning_history();
        revenuePrint(num);

    }

    public void inputWinningNumber(){
        Lotto lotto = new Lotto(new ArrayList<>());
        System.out.println("\n"+PrintMsg.WINNING_NUM_MSG.getMessage());
        String winning[] = Console.readLine().split(",");
        for(int i = 0; i < winning.length; i++){
            lotto.numbers.add(validate_parseInt(winning[i]));
        }
        lotto.validate(lotto.getNumbers());
        lotto.getNumbers().sort(Integer::compareTo);
        winning_number = lotto.getNumbers();
    }

    public int matchRecursive(int p1,int p2,int i) {
        if(p1 == numSize || p2 == numSize) {
            return 0;
        }
        int compare = Integer.compare(lotto_list[i].get(p1),winning_number.get(p2));
        if(compare > 0) {
            return matchRecursive(p1,p2+1,i);
        }
        if(compare < 0) {
            return matchRecursive(p1+1,p2,i);
        }
        return 1 + matchRecursive(p1+1,p2+1,i);
    }

    public void bonusCheck(int i){
        if(lotto_list[i].contains(bonus)){
            bonusCount++;
        }
    }

    public void inputBonus(){
        System.out.println("\n"+PrintMsg.BONUS_NUM_MSG.getMessage());
        bonus = validate_parseInt(Console.readLine());
    }

    public void matchCount(){
        amoutAry = new int[numSize+1];
        for(int i = 0; i < lotto_list.length; i++){
            int num = matchRecursive(0, 0, i);
            if(num == 5){
                bonusCheck(i);
            }
            amoutAry[num]++;
        }
    }

    public void winning_history(){
        System.out.println("\n"+PrintMsg.STATISTIC_MSG.getMessage());
        System.out.println("---");
        for(int i = 3; i < 7; i++){
            System.out.printf(PrintMsg.MATCH_MSG.getMessage(),i,amountPrint[i-3],amoutAry[i]);
            if(i == 5){
                System.out.printf(PrintMsg.BONUS_MSG.getMessage(),i,amountPrint[4],bonusCount);
            }
        }
    }

    public void purchase_history(int num){
        System.out.println("\n"+num+PrintMsg.CHECK_MSG.getMessage());
        for(int i = 0; i < num; i++){
            Lotto lotto = new Lotto(new ArrayList<>());
            lotto_list[i] = lotto.random_range();
            lotto.validate(lotto_list[i]);
            lotto_list[i].sort(Integer::compare);
            System.out.println(lotto_list[i]);
        }
    }

    public void initialLottoArray(int num){
        lotto_list = new ArrayList[num];
        for(int i = 0; i < num; i++){
            lotto_list[i] = new ArrayList<>();
        }
    }

    public int purchase_amount(){
        System.out.println(PrintMsg.INPUT_MSG.getMessage());
        int num = validate_parseInt(Console.readLine());
        return validate_division(num);
    }

    public int validate_parseInt(String str) {
        int num = 0;
        try {
            num = Integer.parseInt(str);
        }catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(PrintMsg.ERROR_MSG.getMessage());
        }
        return num;
    }

    public void revenuePrint(int num) {
        System.out.printf(PrintMsg.REVENUE.getMessage(),revenue_rate(num));
    }

    public double revenue_rate(int num){
        double result = 0;
        for(int i = 3; i <= numSize; i++) {
            result += amoutAry[i] * amount[i-3];
        }
        result += bonusCount * amount[4];
        return (result / (num * one_ticket)) * 100;
    }

    public int validate_division(int amount){
        if(amount % one_ticket != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다. ");
        }
        return amount / one_ticket;
    }

    public class Lotto {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            this.numbers = numbers;
        }

        private void validate(List<Integer> numbers) {
            if (numbers.size() != numSize) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
        }
        // TODO: 추가 기능 구현
        public List<Integer> getNumbers(){
            return numbers;
        }

        public List<Integer> random_range(){
            numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            return numbers;
        }
    }
}

