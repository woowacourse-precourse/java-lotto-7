package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String res = Console.readLine();
        return Integer.parseInt(res);
    }

    public void numberInput() {
        System.out.println();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = changeInput(input);
                Lotto lotto = new Lotto(numbers);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private List<Integer> changeInput(String input) {
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : splitInput) {
            int num = Integer.parseInt(s);
            numbers.add(num);
        }
        return numbers;
    }
}


