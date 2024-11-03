package lotto;

import java.util.HashSet;
import java.util.List;

public class Validation {
    String moneyRegex = "[1-9][0-9]*000";
    String regexLottoNumber = "[1-9]|[1-3][0-9]|4[0-5]";
    String regexWinningNumber = "([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5])){5}";

    void isRightInputMoney(String money) {
        if(!money.matches(moneyRegex)) throw new IllegalArgumentException("[ERROR] 구매입력이 맞지 않습니다.");
    }

    void isRightInputLottos(String lottos) {
        if(!lottos.matches(regexWinningNumber)) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 다른 숫자 6개여야 합니다.");
    }

    void isDistinctNumber(List<Integer> winnings) {
        if (new HashSet<>(winnings).size() < 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }
    }

    void isRightLottoNumber(String number) {
        if(!number.matches(regexLottoNumber)) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public void isContainWinningNumber(int bonusNumber, List<Integer> winnings) {
        if(winnings.contains(bonusNumber)) throw new IllegalArgumentException("[ERROR] 당첨 번호가 포함되어있지 않은 번호를 입력해 주세요.");
    }
}
