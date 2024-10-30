package lotto;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int one_ticket = 1000;
    public static final int numSize = 6;
    public static int bonus;
    public static int bonusCount = 0;
    public static List<Integer> winning_number;
    public static List<Integer>[] lotto_list;
    public static final String amount[] = {"5,000","50,000","1,500,000",
            "30,000,000","2,000,000,000","30,000,000"};
    public enum PrintMsg {
        INPUT_MSG("구입금액을 입력해 주세요."),
        CHECK_MSG("개를 구매했습니다."),
        WINNING_NUM_MSG("당첨 번호를 입력해 주세요."),
        BONUS_NUM_MSG("보너스 번호를 입력해 주세요."),
        STATISTIC_MSG("당첨 통계"),
        ERROR_MSG("[ERROR] 정수 값으로 입력을 해야합니다."),
        REVENUE_MSG("총 수익률은 %d%%입니다."),
        MATCH_MSG("%d개 일치 (%s원) - %d개\n"),
        BONUS_MSG("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n");

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
        lotto_list = purchase_history(num);
        winning_number = inputWinningNumber().getNumbers();
        inputBonus();
        // 당첨 통계
        winning_history();

    }
    public Lotto inputWinningNumber(){
        Lotto lotto = new Lotto(new ArrayList<>());
        System.out.println("\n"+PrintMsg.WINNING_NUM_MSG.getMessage());
        String winning[] = Console.readLine().split(",");
        for(int i = 0; i < numSize; i++){
            try{
                lotto.numbers.add(Integer.parseInt(winning[i]));
            }catch (IllegalArgumentException e){
                System.out.println(PrintMsg.ERROR_MSG.getMessage());
                throw e;
            }
        }
        lotto.validate(lotto.numbers);
        lotto.numbers.sort(Integer::compareTo);
        return lotto;
    }
    public int numberMatch(int i,int p1,int p2,int count){
        while(p1 < numSize && p2 < numSize){
            int result = Integer.compare(lotto_list[i].get(p1),winning_number.get(p2));
            if(result > 0){
                p2++;
                continue;
            }
            if(result < 0){
                p1++;
                continue;
            }
            p1++;
            p2++;
            count++;
        }
        return count;
    }

    public void bonusCheck(int i){
        if(lotto_list[i].contains(bonus)){
            bonusCount++;
        }
    }
    public void inputBonus(){
        System.out.println("\n"+PrintMsg.BONUS_NUM_MSG.getMessage());
        bonus = Integer.parseInt(Console.readLine());
    }
    public int[] matchCount(){
        int[] ary = new int[numSize+1];
        for(int i = 0; i < lotto_list.length; i++){
            int num = numberMatch(i,0,0,0);
            if(num == 5){
                bonusCheck(i);
            }
            ary[num]++;
        }
        return ary;
    }
    public void winning_history(){
        int [] ary = matchCount();
        System.out.println("\n"+PrintMsg.STATISTIC_MSG.getMessage());
        System.out.println("---");
        for(int i = 3; i < 7; i++){
            System.out.printf(PrintMsg.MATCH_MSG.getMessage(),i,amount[i-3],ary[i]);
            if(i == 5){
                System.out.printf(PrintMsg.BONUS_MSG.getMessage(),i,amount[5],bonusCount);
            }
        }
    }
    public List<Integer>[] purchase_history(int num){
        System.out.println("\n"+num+PrintMsg.CHECK_MSG.getMessage());
        List<Integer> lotto_list [] = initialLottoArray(num);
        for(int i = 0; i < num; i++){
            Lotto lotto = new Lotto(new ArrayList<>());
            lotto_list[i] = lotto.random_range();
            lotto.validate(lotto_list[i]);
            lotto_list[i].sort(Integer::compare);
            System.out.println(lotto_list[i]);
        }
        return lotto_list;
    }
    public List[] initialLottoArray(int num){
        List<Integer> list[] = new ArrayList[num];
        for(int i = 0; i < num; i++){
            list[i] = new ArrayList<>();
        }
        return list;
    }
    public int purchase_amount(){
        System.out.println(PrintMsg.INPUT_MSG.getMessage());
        int num = Integer.parseInt(Console.readLine());
        return validate_division(num);
    }
    public int validate_division(int amount){
        if(amount % one_ticket != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다. ");
        }
        return amount / one_ticket;
    }
    public void revenue(){

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

