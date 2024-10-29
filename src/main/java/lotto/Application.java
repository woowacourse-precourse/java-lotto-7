package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static Money getMoney() {
        System.out.print("원하는 금액을 입력하세요 : ");
        String money = Console.readLine();
        return new Money(money);
    }

    private static Lotto getLotto(){
        System.out.print("당첨 로또 번호를 입력하세요 : ");
        List<String> stringLotto = List.of(Console.readLine().split(","));
        List<Integer> lotto = new ArrayList<>();
        for (String str : stringLotto) {
            lotto.add(Integer.parseInt(str));
        }
        return new Lotto(lotto);
    }

    public static void main(String[] args) {
        while (true) {
            try {
                Money money = getMoney();
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                Lotto lotto = getLotto();
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

