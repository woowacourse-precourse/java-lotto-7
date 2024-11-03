package lotto.view;

import java.util.Arrays;
import java.util.List;

public class Validate {

    private static final String NUMERIC_REGEX = "^[0-9]+$";

    public int validateBonusNumber(String bonusNumber){
        checkNumber(bonusNumber);
        if(Integer.parseInt(bonusNumber)>45) throw new IllegalArgumentException("[ERROR] 보너스 번호는 45 이하여야 합니다.");
        return Integer.parseInt(bonusNumber);
    }

    public int validateLottoMoney(String lottoMoney){
        checkNumber(lottoMoney);

        if(Integer.parseInt(lottoMoney) % 1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 입력할 수 있습니다.");
        }

        return Integer.parseInt(lottoMoney);
    }

    public List<Integer> validateLottoNumber(String lottoNumber){
        List<Integer> lottoNumbers = Arrays.stream(lottoNumber.split(","))
                .map(number -> {
                    checkNumber(number);  // 각 숫자가 유효한지 확인
                    int parsedNumber = Integer.parseInt(number);
                    if (parsedNumber > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 45 이하여야 합니다.");
                    return parsedNumber;
                })
                .toList();

        return lottoNumbers;
    }

    private static void checkNumber(String number) {
        if(!number.matches(NUMERIC_REGEX)){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }

        if(Integer.parseInt(number) < 0){
            throw new IllegalArgumentException("[ERROR] 양수만 입력할 수 있습니다.");
        }
    }

}
