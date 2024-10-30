package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.DuplicateValidator;

public record WinNumbers(
        List<Integer> primaryWinNumbers,
        Integer bonusWinNumber
) {

    public static WinNumbers winNumbersFrom(String originWinNumbers) { //이거 어떻게 예쁘게하나
        List<String> numbers = Arrays.stream(originWinNumbers.split(",")).toList();
        List<Integer> extractWinNumbers = new ArrayList<>();
        for (String number : numbers) {
            try {
                extractWinNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
        DuplicateValidator.validatedNumberCount(extractWinNumbers);
        DuplicateValidator.validateDuplicate(extractWinNumbers);
        return new WinNumbers(extractWinNumbers, null);
    }

    public WinNumbers bonusNumberFrom(String bonusNumber) {
        int convertBonusNumber;
        try {
            convertBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        if (primaryWinNumbers.contains(convertBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 로또 번호 입니다.");
        }
        return new WinNumbers(primaryWinNumbers, convertBonusNumber);
    }
}
