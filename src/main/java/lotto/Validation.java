package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private final int PRICE_PER_LOTTO = 1000;

    public void validateLottoPrice(String lottoPrice) {
        int totalPrice = validateNumberFormatException(lottoPrice);
        validateIsPositiveNumber(totalPrice);
        validateIsDividedByPricePerLotto(totalPrice);
    }

    private int validateNumberFormatException(String lottoPrice) {
        try {
            return Integer.parseInt(lottoPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액을 숫자로 입력해 주세요.");
        }
    }

    private void validateIsPositiveNumber(int totalPrice) {
        if (totalPrice < 0) {
            throw new IllegalArgumentException("구입 금액을 양수로 입력해 주세요.");
        }
    }

    private void validateIsDividedByPricePerLotto(int totalPrice) {
        if (totalPrice % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("구입 금액은 " + PRICE_PER_LOTTO + "로 나누어 떨어져야 합니다.");
        }
    }

    public void validateLottoNumber(String lottoNumber) {
        validateLottoNumberFormat(lottoNumber);
        validateNumberOutOfRange(lottoNumber);
        validateHasDuplicates(lottoNumber);
    }

    private void validateLottoNumberFormat(String lottoNumber) {
        Pattern pattern = Pattern.compile("\\d{1,3}(,\\d{1,3}){5}");
        Matcher matcher = pattern.matcher(lottoNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("당첨 입력 형식이 올바르지 않습니다. 콤마(,)로 구분되는 1이상 45 이하 숫자 6개를 입력해 주세요");
        }
    }

    private void validateNumberOutOfRange(String lottoNumber){
        String[] split = lottoNumber.split(",");
        for(String num : split){
            int number = Integer.parseInt(num);
            if(number <= 0 || number >= 46)
                throw new IllegalArgumentException("당첨 번호는 1이상 45이하 숫자로 입력해 주세요.");
        }
    }

    private void validateHasDuplicates(String lottoNumber){
        String[] split = lottoNumber.split(",");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(split));
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(split));
        if(arrayList.size() != hashSet.size())
            throw new IllegalArgumentException("서로 다른 당첨 번호 6개를 입력해 주세요.");
    }
}
