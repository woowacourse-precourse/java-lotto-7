package lotto.view;

import static lotto.validator.InputValidator.validateInputInteger;
import static lotto.validator.InputValidator.validateLottoMoney;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getLottoMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            if (!validateInputInteger(input)) {
                continue;
            }
            int lottoMoney = Integer.parseInt(input);
            if (!validateLottoMoney(lottoMoney)) {
                continue;
            }
            return lottoMoney;
        }
    }

    public static List<Integer> getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers.split(",")) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

    public static int getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
