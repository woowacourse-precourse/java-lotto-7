package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static lotto.domain.Validator.*;

public class InputView {
    private static final int BASIC_MONEY = 1_000;

    public static int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateInput(input);
        return Integer.parseInt(input);
    }

    public static int getLottoNumber(int money) {
        int count = money / BASIC_MONEY;
        System.out.println(count +"개를 구매했습니다.");
        return count;
    }

    public static List<Integer> getInputWinLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> inputLottoNumbers = new ArrayList<>();
        String input = Console.readLine();
        tokenizeInput(input, inputLottoNumbers);
        validateSize(inputLottoNumbers);
        return inputLottoNumbers;
    }

    public static int getInputBonusNumber(List<Integer> inputLottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        int bonusNumber = Integer.parseInt(input);
        return bonusNumber;
    }

}
