package lotto.View;
import Common.Validator;
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
        System.out.println();
        return price/1000;
    }

    public List<Integer> requestNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        System.out.println();
        return Validator.validateNumbers(input);
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        Validator.validateNumberRange(bonus);
        return bonus;
    }
}
