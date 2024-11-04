package lotto.view;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = readLine();
        return amount;
    }

    public List<String> readNumbers() {
        List<String> numbers = new ArrayList<>();

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String rawNumbers = readLine();
        numbers.add(rawNumbers);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        numbers.add(bonusNumber);

        return numbers;
    }

}
