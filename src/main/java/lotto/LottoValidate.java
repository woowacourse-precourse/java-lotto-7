package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidate {

    // 로또 번호의 개수 체크
    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 로또 번호 중복 체크
    public static void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    // 로또 번호 범위 체크
    public static void validateRange(List<Integer> numbers) {
        for (int number:numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이어야 합니다.");
            }
        }
    }

    // 로또 번호가 정수형 숫자가 맞는지 체크
    public static void validateType(List<Integer> numbers) {
        for (Object number : numbers) {
            if (!(number instanceof Integer)) {
                throw new IllegalArgumentException("[ERROR] 리스트에는 정수형 숫자만 포함되어야 합니다.");
            }
        }
    }

    // 로또를 구매한 금액이 0원 보다 작거나 1000으로 나눠 떨어지지 않을 경우 예외 처리
    public static void validateAmount(int amount){
        if (amount <= 0 || amount%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 크고 1000단위여야 합니다.");
        }
    }

    // 로또 번호와 보너스 번호의 중복 여부 검사
    public static void validBonusNumberUnique(List<Integer> winningNumber, int bonusNumber){
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
    }

    // 보너스 번호의 범위 검사
    public static void validateBonusNumberRange(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45사이어야 합니다.");
        }
    }

}
