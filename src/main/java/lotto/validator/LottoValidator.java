package lotto.validator;

import java.util.List;
import lotto.enums.LottoCriteria;

public class LottoValidator {

    public static boolean isInRangeLottoNumbers(List<Integer> lottoNumbers) {
        for(Integer num : lottoNumbers){
            if(num > LottoCriteria.MAX_LOTTO_NUM.getCriteriaVal()){
                return false;
            }
            if(num < LottoCriteria.MIN_LOTTO_NUM.getCriteriaVal()){
                return false;
            }
        }
        return true;
    }
}