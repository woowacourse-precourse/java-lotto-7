package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    public Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. : ");
        String input = Console.readLine().trim();
        List<Integer> winningNumbers = parseInputToList(input);
        return new Lotto(winningNumbers);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요. : ");
        String input = Console.readLine().trim();
        int bonusNumber = Integer.parseInt(input);
        return bonusNumber;
    }

    private List<Integer> parseInputToList(String input) {
        // winningNumbers를 리스트로 변환 기능 구현
        return new ArrayList<>();
    }

}
