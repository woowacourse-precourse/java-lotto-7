package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record WinNumbers(
        List<Integer> winNumbers,
        Integer bonusWinNumber
) {

    public static WinNumbers winNumbersFrom(String originWinNumbers) { //이거 어떻게 예쁘게하나
        List<String> numbers = Arrays.stream(originWinNumbers.split(",")).toList();
        List<Integer> winNumbers = new ArrayList<>();
        for (String number : numbers) {
            try {
                winNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
        return new WinNumbers(winNumbers, null);
    }

    public WinNumbers bonusNumberFrom(String bonusNumber) {
        try {
            return new WinNumbers(winNumbers, Integer.parseInt(bonusNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }
}
