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

    public List<Integer> numberInput() {
        System.out.println();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = changeInput(input);
                Lotto lotto = new Lotto(numbers);
                return numbers;
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

    public int bonusInput() {
        System.out.println();
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int bonusNum = Integer.parseInt(input);

                if(bonusNum < 1 || bonusNum > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
                }
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}