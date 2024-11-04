package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputBonusNumber {
    private final int bonusNumber;

    public InputBonusNumber(String input, List<Integer> winningNumbers) {
        System.out.println("구입금액을 입력해주세요");
        String bonusMoneyString = Console.readLine();
        int bonusNumber = Integer.parseInt(bonusMoneyString);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
