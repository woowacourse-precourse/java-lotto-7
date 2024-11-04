package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class PrizeCount {
    private static Map<Integer, Integer> prizeCount;

    public PrizeCount(){
        prizeCount = new HashMap<>();
    }

    public static Map<Integer, Integer> calculatePrizeCount(Integer prizeNumber) {
        Integer count = prizeCount.getOrDefault(prizeNumber, 0);
        prizeCount.put(prizeNumber, count +1);
        return prizeCount;
    }



    public static Map<Integer, Integer> getPrizeCount(){
        return prizeCount;
    }



}



