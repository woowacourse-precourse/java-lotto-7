package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public static void validateUnit(int remainPurchaseQuantity) {
        if (remainPurchaseQuantity != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위만 가능합니다.");
        }
    }

    public static void validateRange(List<Integer> numbers){
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateDuplicationOfWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호는 중복되지 않아야 합니다.");

    }

    public static void validateDuplicationBetweenWinningAndBonus(List<Integer> numbers, int bonusNumber){
        if (numbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }


}
