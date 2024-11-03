package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static final int UNIT_OF_LOTTO = 1000;
    public static final int LOTTO_NUMBER_LENGTH = 6;
    public static final int MIN_MATCHED_TO_WIN = 3;
    public static final int MAX_MATCHED_TO_WIN = 6;
    public static final int FIRST_PRIZE = 2000000000;
    public static final int SECOND_PRIZE = 30000000;
    public static final int THIRD_PRIZE = 1500000;
    public static final int FOURTH_PRIZE = 50000;
    public static final int FIFTH_PRIZE = 5000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int buy_price = getPrice();
        int num_lotto = buy_price / UNIT_OF_LOTTO;

        Lotto[] lottos = new Lotto[num_lotto];
        issueLotto(num_lotto, lottos);
        List<Integer> winning_numbers = getWinningNumber();
        Lotto winning_lotto = new Lotto(winning_numbers);
        int bonus_number = getBonus(winning_numbers);

        System.out.println("\n당첨 통계\n---");
        int total_money = printWin(lottos, winning_lotto, bonus_number);
        printProfit(buy_price, total_money);
    }

    private static int getPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String input_price = Console.readLine();
        try{
            int price = validatePrice(input_price);
            return price;
        }catch(IllegalArgumentException e){
            System.out.println(e);
            return getPrice();
        }
    }

    private static int validatePrice(String buy_input){
        try{
            int price = Integer.parseInt(buy_input);
            if(price <= 0){
                throw new IllegalArgumentException("[ERROR] Lotto prices should be 1000 won or over.");
            }
            if(price % UNIT_OF_LOTTO != 0){
                throw new IllegalArgumentException("[ERROR] The unit of lotto prices should be 1000 won.");
            }
            return price;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] Lotto number should have number formats");
        }
    }

    private static void issueLotto(int num_lotto, Lotto[] lottos){
        System.out.println("\n" + num_lotto + "개를 구매했습니다.");
        for(int i = 0; i < num_lotto; i++){
            lottos[i] = createLotto();
            System.out.println(lottos[i].getNumbers());
        }
        System.out.println();
    }

    private static Lotto createLotto(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    private static List<Integer> getWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winning_input = Console.readLine();
        try{
            List<Integer> winning_numbers = validateWinningNumber(winning_input);
            winning_numbers.sort(Comparator.naturalOrder());
            return winning_numbers;
        }catch(IllegalArgumentException e){
            System.out.println(e);
            return getWinningNumber();
        }
    }

    private static List<Integer> validateWinningNumber(String winning_input){
        List<Integer> winning_numbers = new ArrayList<>();
        if(winning_input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] Please enter the winning numbers");
        }
        try{
            String[] win_numbers = winning_input.split(",");
            winning_numbers = checkNumber(win_numbers, winning_numbers);
            return winning_numbers;
        }catch(IllegalArgumentException e){
            System.out.println(e);
            return getWinningNumber();
        }
    }

    private static List<Integer> checkNumber(String[] win_numbers, List<Integer> winning_numbers){
        if(win_numbers.length != LOTTO_NUMBER_LENGTH){
            throw new IllegalArgumentException("[ERROR] The winning numbers should be 6.");
        }
        try{
            for(int i = 0; i < win_numbers.length; i++){
                int num_element = Integer.parseInt(win_numbers[i]);
                checkPositive(num_element);
                checkDuplicate(winning_numbers, num_element);
                winning_numbers.add(num_element);
            }
            return winning_numbers;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] The winning numbers should have number formats.");
        }
    }

    private static void checkPositive(int num){
        if(num <= 0){
            throw new IllegalArgumentException("[ERROR] The numbers should be positive.");
        }
    }

    private static void checkDuplicate(List<Integer> winning_numbers, int num_element){
        if(winning_numbers.contains(num_element)){
            throw new IllegalArgumentException("[ERROR] The numbers shouldn't be duplicated.");
        }
    }

    private static int getBonus(List<Integer> winning_numbers){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonus_input = Console.readLine();
        try{
            int bonus = validateBonus(winning_numbers, bonus_input);
            return bonus;
        }catch(IllegalArgumentException e){
            System.out.println(e);
            return getBonus(winning_numbers);
        }
    }

    private static int validateBonus(List<Integer> winning_numbers, String bonus_input){
        try{
            int bonus = Integer.parseInt(bonus_input);
            checkPositive(bonus);
            checkDuplicate(winning_numbers, bonus);
            return bonus;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] The numbers should have number formats.");
        }
    }

    private static int printWin(Lotto[] lottos, Lotto winning_lotto, int bonus){
        int total = 0;
        int[] prize = {FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, FIRST_PRIZE};
        for(int i = MIN_MATCHED_TO_WIN; i <= MAX_MATCHED_TO_WIN; i++){
            int count = howMatched(lottos, winning_lotto, bonus, i);
            if(i == MAX_MATCHED_TO_WIN){
                int second_count = printSecondPrize(lottos, bonus, i, count);
                System.out.println(i+"개 일치 ("+strtoint(prize[i-MIN_MATCHED_TO_WIN])+"원) - "+(count-second_count)+"개");
                total += second_count * SECOND_PRIZE + (count - second_count) * prize[i - MIN_MATCHED_TO_WIN];
                return total;
            }
            System.out.println(i + "개 일치 (" + strtoint(prize[i - MIN_MATCHED_TO_WIN]) + "원) - " + count  + "개");
            total += count * prize[i - MIN_MATCHED_TO_WIN];
        }
        throw new IllegalArgumentException("[ERROR] Some error in statistics is occurred");
    }

    private static int printSecondPrize(Lotto[] lottos, int bonus, int i, int count){
        int second_count = 0;
        if(count == 0){
            System.out.println(i - 1 + "개 일치, 보너스 볼 일치 (" + strtoint(SECOND_PRIZE) + "원) - 0개");
            return 0;
        }
        for(int j = 0; j < lottos.length; j++){
            if(isBonusMatched(lottos[j].getNumbers(), bonus) == 1){
                second_count += 1;
            }
        }
        System.out.println((i-1)+"개 일치, 보너스 볼 일치 (" + strtoint(SECOND_PRIZE) + "원) - "+second_count+"개");
        return second_count;
    }

    private static String strtoint(int i){
        if(i == FIFTH_PRIZE){
            return String.format("%,d", i);
        }
        if(i == FOURTH_PRIZE){
            return String.format("%,d", i);
        }
        if(i == THIRD_PRIZE){
            return String.format("%,d", i);
        }
        if(i == SECOND_PRIZE){
            return String.format("%,d", i);
        }
        return String.format("%,d", i);
    }

    private static int isBonusMatched(List<Integer> numbers, int bonus){
        if(numbers.contains(bonus)){
            return 1;
        }
        return 0;
    }

    private static int howMatched(Lotto[] lottos, Lotto winning_lotto, int bonus, int i){
        int count = 0;
        for(int j = 0; j < lottos.length; j++){
            List<Integer> numbers = lottos[j].getNumbers();
            int matched = 0;
            for(int k = 0; k < LOTTO_NUMBER_LENGTH; k++){
                matched += matchedCheck(numbers, winning_lotto, k);
            }
            matched += isBonusMatched(numbers, bonus);
            if(matched == i){
                count += 1;
            }
        }
        return count;
    }

    private static int matchedCheck(List<Integer> numbers, Lotto winning_lotto, int k){
        if(numbers.contains(winning_lotto.getNumbers().get(k))){
            return 1;
        }
        return 0;
    }

    private static void printProfit(int buy_price, int total){
        float profit = ((float)total / buy_price) * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }
}
