package lotto;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int one_ticket = 1000;
    public class print_msg{
        static final String inputMsg = "구입금액을 입력해 주세요.";
        static final String checkMsg = "개를 구매했습니다.";
        static final String winning_num = "당첨 번호를 입력해 주세요.";
        static final String bonus_num = "보너스 번호를 입력해 주세요.";
        static final String statistic = "당첨 통계";
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
    public void logic(){
        int num = purchase_amount();
    }

    public void purchase_history(int num){
        System.out.println(num+print_msg.checkMsg);
        List<Integer> lotto_list [] = initialLottoArray(num);
        for(int i = 0; i < num; i++){
            List<Integer> list = new ArrayList<>();
            Lotto lotto = new Lotto(list);
            lotto_list[i] = lotto.random_range();
        }
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
            validate(numbers);
            this.numbers = numbers;
        }

        private void validate(List<Integer> numbers) {
            if (numbers.size() != 6) {
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

