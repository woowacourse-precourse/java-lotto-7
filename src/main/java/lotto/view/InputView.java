package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.parsers.Parser;

public class InputView {
    public int inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        String input = readLine();
        while (!Parser.isInteger(input)) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            input = readLine();
        }
        return Integer.parseInt(input);
    }


    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        String numbers = readLine();
        return Parser.parseStringToList(numbers);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(readLine());
    }
}