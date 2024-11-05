package lotto;

import java.util.List;

public class FindError {

    public static Integer moneyError(String input) {
        int money;

        try {
            money = Integer.parseInt(input);
            if (money <= 0) { // 시도 횟수가 0 이하인 경우 예외 처리
                throw new IllegalArgumentException("[ERROR] 돈은 0이상이여야 합니다.");
            }
            if (money % 1000 != 0){
                throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {//숫자가 아닌 경우 예외 처리
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        return money;
    }

    public static void validateBonusNumber(Integer bonusNumber, List<Integer> winNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
