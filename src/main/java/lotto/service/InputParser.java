package lotto.service;

import lotto.common.ConstantData;
import lotto.common.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class InputParser {

    public int calculatePapers(int money){
        ValidationUtils.validateNotUsedNumber(money);
        ValidationUtils.validateUnit(money);

        return money / ConstantData.MONEY_UNIT;
    }

    public int strToInt(String str){
        ValidationUtils.validateNull(str);
        ValidationUtils.validateInt(str);

        return Integer.parseInt(str);

    }

    public List<Integer> splitToArray(String readData) {
        List<Integer> array = new ArrayList<>();
        String[] str = readData.split(",");

        ValidationUtils.validateNumberSize(str.length);

        for (String data : str) { array.add( strToInt(data.trim()) ); }

        ValidationUtils.validateDuplicateWinNumber(array);

        return array;
    }

    public List<Integer> sortArray(List<Integer> lottoPaper){
        Collections.sort(lottoPaper);

        return lottoPaper;
    }


}
