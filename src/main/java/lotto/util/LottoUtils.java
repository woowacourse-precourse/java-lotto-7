package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

public class LottoUtils {

    private static final int MIN_NUMBER = 1; 
    private static final int MAX_NUMBER = 45; 
    private static final String DELIMITER = ","; 
    private static final int NUMBERS_COUNT = 6; 

    public static Lotto createLotto() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_COUNT));
    
        Collections.sort(lotto);
        
        return new Lotto(lotto);
    }

    public static String[] splitInput(String input) {
        return input.split(DELIMITER);
    }

    public static void validatePositiveNumber(String input, String message) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] "+message+" 숫자로만 이루어진 양수여야 합니다.");
        }
    }

    public static void validateInputNumbersCount(String[] input, String message) {
        if (input.length != NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] "+message+" " + NUMBERS_COUNT + "개여야 합니다.");
        }
    }

    public static void validateNumberRange(int number, String message) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] "+message+" " + MIN_NUMBER + "와 " + MAX_NUMBER + " 사이여야 합니다.");
        }
    }
}
