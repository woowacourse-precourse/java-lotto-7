package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoNumberInputView {
    public List<Integer> inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = parseInputToList(input);
        return winningNumbers;
    }
    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
    private List<Integer> parseInputToList(String input) {
        String[] numbers = input.split(",");
        List<Integer> result = new ArrayList<>();
        for (String num : numbers) {
            result.add(Integer.parseInt(num.trim()));
        }
        System.out.println(result);
        return result;
    }
}
