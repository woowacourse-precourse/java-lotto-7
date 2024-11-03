package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public int getAmountInput() throws IllegalArgumentException {
        String input = Console.readLine();
        validateInputAmount(input);
        return Integer.parseInt(input);
    }


    public void validateInputAmount(String input) throws IllegalArgumentException {
        if (InputValidator.isNullOrBlank(input)) {
            throw new IllegalArgumentException("[ERROR] 빈칸 없이 입력해주세요.");

        }
        if (!InputValidator.isValidFormatForMoney(input)) {
            throw new IllegalArgumentException("[ERROR] 천 이상의 숫자만 입력해 주세요.");
        }
        int numericInput = Integer.parseInt(input);
        if (!InputValidator.isThousandUnit(numericInput)) {
            throw new IllegalArgumentException("[ERROR] 천원단위로 입력해 주세요");
        }
    }

    public List<Integer> getLottoNumber() {

        String input = Console.readLine();

        validateLottoInput(input);

        return convertToNumberList(input);

    }

    private void validateLottoInput(String lottoNumber) {
        if (InputValidator.isNullOrBlank(lottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 빈칸 없이 입력해주세요.");
        }
        if (!InputValidator.isValidFormatForLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 쉼표를 구분자로 한자리의 숫자씩만 입력해주세요.");
        }
        String[] splitNumbers = lottoNumber.split(",");

        if (!InputValidator.isCountSix(splitNumbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 총 6개여야 합니다.");
        }
        if (!InputValidator.isUniqueNumbers(splitNumbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복되지 않게 입력해주세요");
        }
        if (!InputValidator.isInRange(splitNumbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이의 숫자를 입력해 주세요.");
        }
    }

    public int getBonusNumber(List<Integer> lottoNumbers) {
        String stringBonusNumber = Console.readLine();
        validateBonusNumber(stringBonusNumber, lottoNumbers);
        return Integer.parseInt(stringBonusNumber);

    }

    private void validateBonusNumber(String bonusNumber, List<Integer> lottoNumber) {
        if (InputValidator.isNullOrBlank(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 빈칸 없이 입력해주세요.");
        }
        if (!InputValidator.isNumeric(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        if (!InputValidator.isUnique(bonusNumber, lottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 다른 번호를 입력해 주세요");
        }
        if (!InputValidator.isInRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이의 숫자를 입력해 주세요.");
        }
    }

    private List<Integer> convertToNumberList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
