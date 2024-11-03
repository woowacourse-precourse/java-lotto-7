package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserBonusNumberInput {
    private int bonusNumber;

    public int validation(List<Integer> lottoNumbers) {
        while (true) {
            try {
                bonusNumber = rangeValidation(parseInput(getInput()));
                bonusDuplicationCheck(lottoNumbers);

                System.out.println();
                return bonusNumber;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 오류 메시지 출력 후 재입력
            }
        }
    }

    private String getInput() {

        System.out.println("보너스 번호를 입력해 주세요.");

        return Console.readLine();
    }

    private int parseInput(String getInput) {
        try {
            return Integer.parseInt(getInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 한 개의 정수여야 합니다.");
        }
    }

    private int rangeValidation(int bonusNumber) {

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 정수여야 합니다.");
        }

        return bonusNumber;
    }

    private void bonusDuplicationCheck(List<Integer> lottoNumbers) {

        Set<Integer> bonusCheck = new HashSet<>(lottoNumbers);

        if (!bonusCheck.add(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }
}