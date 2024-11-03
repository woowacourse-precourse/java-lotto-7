package validator;

import java.util.Collections;
import java.util.List;
import model.Lotto;

public class Validator {
    public static void lottoShouldBeBetweenOneAndFortyFive(List<Integer> lotto) {
        for (Integer lottoNumber : lotto) {
            shouldBeBetweenOneAndFortyFive(lottoNumber);
        }
    }

    public static void shouldBeBetweenOneAndFortyFive(Integer lottoNumber) {
        if (!(1 <= lottoNumber && lottoNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위가 1에서 45 사이를 초과 했습니다."); // TODO: 에러 메세지 작성
        }
    }

    public static void lottoShouldNotOverlap(List<Integer> lotto) {
        for (Integer lottoNumber : lotto) {
            if (Collections.frequency(lotto, lottoNumber) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자가 중복되었습니다."); // TODO: 에러 메세지 작성
            }
        }
    }

    public static void shouldNotOverlap(Lotto lotto, String bonusNumber) {
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (lottoNumber.equals(Integer.parseInt(bonusNumber))) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 보너스 번호가 중복 되었습니다.");
            }
        }
    }

    public static void lottoNumbersShouldBeSix(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자는 6개 이어야 합니다."); // TODO: 에러 메세지 작성
        }
    }

    public static void lottoShouldBeSortedInAscendingOrder(List<Integer> lotto) {
        Integer value = 0;
        for (Integer lottoNumber : lotto) {
            if (lottoNumber <= value) {
                throw new IllegalArgumentException("[ERROR] 로또가 오름차순 정렬이 되어있지 않습니다."); // TODO: 에러 메세지 작성
            }
            value = lottoNumber;
        }
    }

    public static void shouldBeOnlyNumber(String money) {
        for (int i = 0; i < money.length(); i++) {
            char number = money.charAt(i);
            if (!util.Validator.isNumber(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다."); // TODO: 에러 메세지 추가
            }
        }
    }


    public static void shouldNotBeEmpty(String money) {
        if (money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액이 입력되지 않았습니다."); // TODO: 에러 메세지 추가
        }
    }

    public static void shouldNotBeDividedBy1000(String money) {
        if (money.length() < 3) {
            throw new IllegalArgumentException("[ERRER] 입금 금액은 1000의 배수여야합니다."); // TODO: 에러 메세지 추가
        }

        String checkPoint = money.substring(money.length() - 3);

        if (!checkPoint.equals("000")) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위 입니다."); // TODO: 에러 메세지 추가
        }
    }

    public static void moneyShouldNotBeTooBig(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액의 값이 너무 큽니다."); // TODO: 에러 메세지 추가
        }
    }

}
