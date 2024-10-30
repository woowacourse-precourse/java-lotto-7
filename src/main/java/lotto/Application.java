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
    public class print_msg{
        static final String inputMsg = "구입금액을 입력해 주세요.";
        static final String checkMsg = "개를 구매했습니다.";
        static final String winning_numMsg = "당첨 번호를 입력해 주세요.";
        static final String bonus_numMsg = "보너스 번호를 입력해 주세요.";
        static final String statisticMsg = "당첨 통계";
        static String matchMsg = "%d개 일치 (%s원) - %d개\n";
        static String bonusMsg = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
        static String errorMsg = "[ERROR] 정수 값으로 입력을 해야합니다.";
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
        System.out.println("\n"+print_msg.winning_numMsg);
        String winning[] = Console.readLine().split(",");
        for(int i = 0; i < numSize; i++){
            try{
                lotto.numbers.add(Integer.parseInt(winning[i]));
            }catch (IllegalArgumentException e){
                System.out.println(print_msg.errorMsg);
                throw e;
            }
        }
        lotto.validate(lotto.numbers);
        lotto.numbers.sort(Integer::compareTo);
        return lotto;
    }
    public int numberMatch(int i){
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while(p1 < numSize && p2 < numSize){
            if(lotto_list[i].get(p1) > winning_number.get(p2)){
                p2++;
                continue;
            }
            if(lotto_list[i].get(p1) < winning_number.get(p2)){
                p1++;
                continue;
            }
            p1++;
            p2++;
            count++;
        }
        if(count == 5){
            bonusCheck(i);
        }
        return count;
    }
    public void bonusCheck(int i){
        if(lotto_list[i].contains(bonus)){
            bonusCount++;
        }
    }
    public void inputBonus(){
        System.out.println("\n"+print_msg.bonus_numMsg);
        bonus = Integer.parseInt(Console.readLine());
    }
    public int[] matchCount(){
        int[] ary = new int[numSize+1];
        for(int i = 0; i < lotto_list.length; i++){
            ary[numberMatch(i)]++;
        }
        return ary;
    }
    public void winning_history(){
        int [] ary = matchCount();
        System.out.println("\n"+print_msg.statisticMsg);
        System.out.println("---");
        for(int i = 3; i < 7; i++){
            System.out.printf(print_msg.matchMsg,i,amount[i-3],ary[i]);
        }
    }
    public List<Integer>[] purchase_history(int num){
        System.out.println("\n"+num+print_msg.checkMsg);
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
        System.out.println(print_msg.inputMsg);
        int num = Integer.parseInt(Console.readLine());
        return validate_division(num);
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

