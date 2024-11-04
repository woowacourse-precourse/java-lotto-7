package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BonusNumberInput {
    public int inputBonusNumber(List<Integer> numbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int number = Integer.parseInt(Console.readLine().trim());
                checkNumber(number, numbers);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkNumber(int bonusNumber, List<Integer> numbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        for (Integer number : numbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[Error] 앞의 숫자와 중복되지 않는 새로운 숫자를 입력하세요.");
            }
        }
    }
}
