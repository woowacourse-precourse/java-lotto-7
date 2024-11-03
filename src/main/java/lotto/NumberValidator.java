package lotto;

import java.util.List;

public class NumberValidator {
    public static boolean isValidNumber(String inputSequence) {
        try {
            validateNumber(inputSequence);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("");
            return false;
        }
    }

    public static boolean isValidPrice(String inputSequence) {
        try {
            validatePrice(inputSequence);
            return true;        
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("");
            return false;
        }
    }

    public static boolean isValidLotto(List<Integer> numbers) {
        try {
            Lotto lotto = new Lotto(numbers);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("");
            return false;
        }
    }

    public static boolean isValidBonus(int bonusNumber, Lotto winningLotto) {
        try {
            validateBonus(bonusNumber, winningLotto);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("");
            return false;
        }
    }

    public static void validatePrice(String inputSequence) {
        validateNumber(inputSequence);

        int lottoPrice = Integer.parseInt(inputSequence);
        if (lottoPrice <= 0 || lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 양수를 입력해 주세요.");
        }
    }

    public static void validateNumber(String inputSequence) {
        try {
            Integer.parseInt(inputSequence);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
        }
    }

    public static void validateBonus(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 정수여야 합니다.");
        }
        if (!winningLotto.isUniqueWithBonus(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }



}
