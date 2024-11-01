package lotto.domain.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.domain.lottos.Lotto;


public class UserMainLottoFactory {
    private final static String LOTTO_DELIMITER = ",";

    public Lotto make(String input) {
        String[] separatedInputValues = input.split(LOTTO_DELIMITER);
        List<Integer> lottoNumber = convertToNumbers(separatedInputValues);
        
        return new Lotto(lottoNumber);
    }

    private List<Integer> convertToNumbers(String[] strArray) {
        List<Integer> lottoNumber = new ArrayList<>();

        for (String value : strArray) {
            value = value.trim();
            validateContainSpecialCharacters(value);
            validateEmpty(value);

            lottoNumber.add(changeToNumber(value));
        }
        return lottoNumber;
    }

    private static int changeToNumber(String value) {
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호를 숫자로 입력해 주세요");
        }
        return num;
    }


    private static void validateContainSpecialCharacters(String value) {
        Matcher matcher = Pattern.compile("[!@#$%^&*().?\":{}|<>]").matcher(value);
        if (matcher.find()) {
            throw new IllegalArgumentException("잘못된 구분자를 입력했습니다.");
        }
    }


    private static void validateEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("빈 입력값이 있습니다.");
        }
    }

}
