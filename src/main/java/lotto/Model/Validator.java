package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validatePrice(int price){
        if (price <= 0){
            throw new IllegalArgumentException("[ERROR] 금액은 양의 정수로 입력되어야 합니다.");
        }
        if (price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000단위로 입력되어야 합니다.");
        }
    }

    public static void validateWinNumbers(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : winNumbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지입니다.");
            }
            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }

    public static void validateBonusNumber(int bonus, List<Integer> winNumbers) {
        if (bonus < 1 || bonus > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자 범위는 1~45까지입니다.");
        }
        if (winNumbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
