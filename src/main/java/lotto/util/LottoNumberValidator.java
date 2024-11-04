package lotto.util;

import java.util.List;

public final class LottoNumberValidator {
    public static void validateSize(List<Integer> numbers) {
        int lottoSize = LottoConstant.LOTTO_SIZE.getIntValue();
        if (numbers.size() != lottoSize) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개여야 합니다.", lottoSize));
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidator::validateNumberInRange);
    }

    public static void validateDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateBonusNumberDuplicates(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public static void validateNumberInRange(int number) {
        int minNumber = LottoConstant.MIN_NUMBER.getIntValue();
        int maxNumber = LottoConstant.MAX_NUMBER.getIntValue();

        if (number < minNumber)
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d 이상이어야 합니다.", minNumber));
        if (number > maxNumber)
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d 이하이어야 합니다.", maxNumber));
    }
}
