package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class Parsing {
    public int stringToInteger(String purchaseInput){
        return Integer.parseInt(purchaseInput);
    }

    public List<Integer> stringToIntegerArray(String winningNumberInput){
        String[] separated = winningNumberInput.split(",");
        List<Integer> getIntegerArray = new ArrayList<>();
        for(String str:separated){
            getIntegerArray.add(Integer.parseInt(str));
        }
        return getIntegerArray;
    }
}
