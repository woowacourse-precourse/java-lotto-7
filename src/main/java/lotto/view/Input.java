package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Input {

    public static int moneyInput(){
        System.out.println("구입금액을 입력해 주세요.");
        try{
            int money = Integer.parseInt(Console.readLine());
            System.out.println();
            if(money % 1000 != 0)
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            return divide1000(money);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 숫자를 입력해 주세요.");
        }
    }

    private static int divide1000(int money) {
        return money / 1000;
    }

    public static List<Integer> autoLottoInput() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Integer> winnerLottoNum(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<String> input = Arrays.asList(Console.readLine().split(","));
        List<Integer> winnerLotto = new ArrayList<>();
        for (String num : input) {
            winnerLotto.add(Integer.parseInt(num.trim()));
        }
        return winnerLotto;
    }

    public static int bonusNum(){
        System.out.println("\n보너스 번호 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }
}

