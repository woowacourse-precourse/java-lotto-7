package lotto.View;
import camp.nextstep.edu.missionutils.Console;
import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int requestPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        if (price % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        return price/1000;
    }

    public List<Integer> requestNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(number);
        }
        return numbers;
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonus;
    }
}
