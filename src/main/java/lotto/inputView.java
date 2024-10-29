package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class inputView {
    private static Money getUserMoney() {
        System.out.print("원하는 금액을 입력하세요 : ");
        String money = Console.readLine();
        return new Money(money);
    }

    private static Lotto getUserLotto() {
        System.out.print("당첨 로또 번호를 입력하세요 : ");
        List<String> numberLotto = List.of(Console.readLine().split(","));
        List<Integer> lotto = new ArrayList<>();
        for (String str : numberLotto) {
            lotto.add(Integer.parseInt(str));
        }
        return new Lotto(lotto);
    }

    private static AdditionalNumber getUserAdditionalNumber() {
        System.out.print("보너스 번호를 입력하세요 : ");
        String additionalNumber = Console.readLine();
        return new AdditionalNumber(additionalNumber);
    }

    public Money getMoney() {
        Money money;
        while (true) {
            try {
                money = getUserMoney();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public Lotto getLotto() {
        Lotto lotto;
        while (true) {
            try {
                lotto = getUserLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    public AdditionalNumber getAdditionalNumber() {
        AdditionalNumber additionalNumber;
        while (true) {
            try {
                additionalNumber = getUserAdditionalNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return additionalNumber;
    }
}