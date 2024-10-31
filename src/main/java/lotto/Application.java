package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> makeLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int budget = Integer.parseInt(Console.readLine());
        if(budget<1000){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }

        int count = budget/1000;
        System.out.println();
        System.out.println(count+"개를 구매했습니다.");

        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<count;i++){
            lottos.add(new Lotto(makeLotto()));
        }
    }
}
