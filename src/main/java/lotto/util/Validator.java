package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.Constants;

public class Validator {
    public void isInputPriceValid(String price) {
        if(price == null || price.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 가격은 공백이나 null값이 될 수 없습니다.");
        }else if(!price.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 가격은 숫자만 입력할 수 있습니다.");
        }else if(Integer.parseInt(price) < 0) {
            throw new IllegalArgumentException(("[ERROR] 가격은 음수가 될 수 없습니다."));
        }else if(Integer.parseInt(price) % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 가격은 1000원 단위여야 합니다.");
        }
    }

    public void isBonusNumberValid(String bonusNumber) {
        if(bonusNumber == null || bonusNumber.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 공백이나 null값이 될 수 없습니다.");
        }else if(!bonusNumber.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자만 입력할 수 있습니다.");
        }else if(Integer.parseInt(bonusNumber) < 1 && Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException(("[ERROR] 보너스 숫자는 1 ~ 45 범위여야 합니다."));
        }
    }

    public void isBonusNumberDuplicated(String bonusNumber, List<Integer> lottoNumbers) {
        if(lottoNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 숫자와 중복될 수 없습니다.");
        }
    }

    public void isLottoNumberValid(String lottoNumber) {
        if(lottoNumber==null || lottoNumber.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 공백이나 null값이 될 수 없습니다.");
        }else if(!lottoNumber.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 숫자만 입력할 수 있습니다.");
        }else if(Integer.parseInt(lottoNumber) < 1 && Integer.parseInt(lottoNumber) > 45) {
            throw new IllegalArgumentException(("[ERROR] 당첨 숫자는 1 ~ 45 범위여야 합니다."));
        }
    }

    public void isLottoNumbersValid(List<Integer> lottoNumbers) {
        Set<Integer> removeDuplicates = new HashSet<>(lottoNumbers);
        if(removeDuplicates.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 중복될 수 없습니다.");
        }else if(lottoNumbers.size() > 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 6개를 넘을 수 없습니다.");
        }
    }

}
