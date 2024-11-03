package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoInputConverter {

    public int convertMoney(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> convertNumbers(String input) {
        String[] split = input.split(",");

        List<Integer> list = new ArrayList<>();
        for (String s : split) {
            validateNumber(s);
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    public int convertBonusNumber(String input) {
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또번호 및 보너스번호는 숫자만 입력 가능합니다.");
        }
    }

}
