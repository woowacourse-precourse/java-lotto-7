package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputBonusNumber {
    private static final String EMPTY_INPUT_ERROR = "[ERROR] 번호를 입력해주세요.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 번호는 숫자로만 입력해주세요.";
    private static final String RANGE_ERROR = "[ERROR] 번호는 1에서 45 사이여야 합니다.";
    private static final String DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    public int inputBonusNumber(List<Integer> lottoNumbers) {
        int bonusNumber;

        while (true) {
            System.out.println("보너스 번호를 입력해 주세요. : ");
            String input = Console.readLine();

            try {
                bonusNumber = parseBonusNumber(input);
                validateBonusNumber(bonusNumber, lottoNumbers);
                System.out.println();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private int parseBonusNumber(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }
}
