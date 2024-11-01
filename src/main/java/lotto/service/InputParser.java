package lotto.service;

import lotto.common.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class InputParser {

    public int calculatePapers(int money){
        ValidationUtils.validateNULL(money);
        ValidationUtils.validateUnit(money);

        return money / 1000;
    }

    public int strToInt(String str){
        int number;

        ValidationUtils.validateNULL(str);
        ValidationUtils.validateInt(str);

        number = Integer.parseInt(str);
        return number;

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
