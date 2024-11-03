package lotto;

import java.util.HashSet;
import java.util.Set;

public class Verifier {
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 45;
    private static final Integer LOTTO_SIZE = 6;
    private Set<Integer> lottoNumbers = new HashSet<>();

    // 입력값이 올바른 구매 금액인지 검증
    public boolean isValidPurchaseAmount(String input) {
        try {
            int amount = integerConversion(input);
            validatePurchaseAmount(amount);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // 0. 정수인지 확인
    // 1. 지정된 범위안의 숫자인지 확인
    // 2. 기존 로또 번호에 중복되는 값인지 확인
    public boolean isValidPlusNumber(String input) {
        try {
            int number = integerConversion(input);
            lottoNumberRangeCheck(number);
            lottoNumberDuplicateCheck(number);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Integer integerConversion(String inputData) {
        try {
            return Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 값 입니다. 정수를 입력 해주세요.");
        }
    }

    // 올바른 구매 금액인지 확인
    // 양수값인지, 1000이상 정수인지 확인
    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 음수입니다. 양수 값을 입력 해주세요");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액의 단위가 올바르지 않습니다.1000원 단위로 입력해주세요.");
        }
    }

    /**
     * 0. 쉼표(,)를 통해 분리된 값이 정수여야 한다.
     * 1. 각 숫자가 1~45 사이의 값이어야 한다.
     * 2. 각 숫자가 중복되지 않는 값이어야 한다.
     */
    public boolean isValidWinningNumbers(String inputData) {
        try {
            validateLottoNumbers(inputData);
            validateLottoSize();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void validateLottoNumbers(String inputData) {
        String[] splitData = inputData.split(",");
        lottoNumbers.clear();
        for (String s : splitData) {
            int num = integerConversion(s); // 정수 검사
            lottoNumberRangeCheck(num); // 범위 검사
            lottoNumberDuplicateCheck(num); // 중복 검사
            lottoNumbers.add(num);
        }
    }

    public void lottoNumberDuplicateCheck(int num) {
        if (lottoNumbers.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 값을 입력할 수 없습니다.");
        }
    }

    public void validateLottoSize() {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void lottoNumberRangeCheck(int num) {
        if (num < START_INCLUSIVE || num > END_INCLUSIVE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 값 이어야 합니다.");
        }
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
