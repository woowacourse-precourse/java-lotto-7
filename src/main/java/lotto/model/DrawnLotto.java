package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DrawnLotto {
    private final Lotto drawnLotto;
    private final int bonusNumber;

    public DrawnLotto(String drawnNumbersInput, String bonusNumberInput) {
        this.drawnLotto = new Lotto(parseDrawnNumbers(drawnNumbersInput));
        this.bonusNumber = parseBonusNumber(bonusNumberInput);
        validateBonusNumber();
    }

    private List<Integer> parseDrawnNumbers(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }
        try {
            return Arrays.stream(numbers).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    private int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void validateBonusNumber() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (drawnLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public int countHits(Lotto lotto) {
        int count = 0;
        for (int num : lotto.getNumbers()) {
            if (drawnLotto.getNumbers().contains(num)) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberHit(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }


}
