package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.sql.Array;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class Application {
    public static void main(String[] args) {
        int attempts= validateBetAmount();
        printEntries(attempts);

  }

    private static int validateBetAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        int betAmount = Integer.parseInt(input);
        if(betAmount<1000){
            throw new IllegalArgumentException("베팅 금액이 1000원 미만입니다");
        }
        if(betAmount%1000!=0) {
            throw new IllegalArgumentException("베팅 금액이 1000원 단위가 아닙니다");
        }
        int attempts = betAmount/1000;
        System.out.println(attempts + "개를 구매했습니다.");
        return attempts;
    }
    private static void printEntries(int attempts) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0; i<attempts; i++){
            List<Integer> entries = new ArrayList<>();
            entries = Randoms.pickUniqueNumbersInRange(1,45,6);
            entries.sort(Comparator.naturalOrder());
            lists.add(entries);
        }
        for(int j=0; j<attempts; j++){
            System.out.println(lists.get(j));
        }
    }
}
