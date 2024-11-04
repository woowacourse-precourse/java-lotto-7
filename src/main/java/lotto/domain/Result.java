package lotto.domain;

import java.util.HashMap;

public class Result {
    private HashMap<Integer, Integer> resultMap;

    public Result() {
        resultMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> getResultMap() {
        return resultMap;
    }
}
