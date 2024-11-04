package lotto.View;
import lotto.Common.Formatter;
import lotto.Common.Validator;
import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Lotto;

import java.text.Format;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int requestPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = Console.readLine();
        if (!Formatter.canParseInt(line)) throw new IllegalArgumentException("구입 금액은 숫자만 입력해야 합니다.");
        int price = Integer.parseInt(line);
        if (price % 1000 != 0) throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        System.out.println();
        return price/1000;
    }

    public Lotto requestNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> numbers = Arrays.stream(input)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println();
        return new Lotto(numbers);
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String line = Console.readLine();
        if (!Formatter.canParseInt(line)) throw new IllegalArgumentException("보너스 번호는 숫자만 입력해야 합니다.");
        int bonus = Integer.parseInt(line);
        Validator.validateNumberRange(bonus);
        return bonus;
    }
}
