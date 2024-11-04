package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입할 금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 금액을 입력해주세요.");
        }
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요");
        String input = Console.readLine();
        List<LottoNumber> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static LottoNumber inputBonusNumber(Lotto winningLotto) {
        System.out.println("보너스 번호를 입력해주세요.");
        try {
            int number = Integer.parseInt(Console.readLine().trim());
            LottoNumber bonusNumber = new LottoNumber(number);
            if (winningLotto.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 보너스 번호를 입력해주세요.");
        }
    }
}
