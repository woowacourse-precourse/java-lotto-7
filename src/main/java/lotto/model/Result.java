package lotto.model;

import lotto.enumValue.CommonMessage;
import lotto.enumValue.Number;
import lotto.enumValue.ResultMessage;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final int ZERO = Number.ZERO.getValue();

    private Map<Integer, Integer> lottoResult = new HashMap<>();

    public Result() {
        lottoResult.put(ZERO, ZERO);
        lottoResult.put(Number.FIFTH.getValue(), ZERO);
        lottoResult.put(Number.FOURTH.getValue(), ZERO);
        lottoResult.put(Number.THIRD.getValue(), ZERO);
        lottoResult.put(Number.SECOND.getValue(), ZERO);
        lottoResult.put(Number.FIRST.getValue(), ZERO);
    }

    public void setResult(int matchNumber) {
        lottoResult.replace(matchNumber, lottoResult.get(matchNumber) + 1);
    }

    public Map<Integer, Integer> getLottoResult() {
        return lottoResult;
    }

    @Override
    public String toString() {
        return ResultMessage.ANNOUNCE.getDescription()
                + ResultMessage.FIFTH.getDescription() + lottoResult.get(5000) + CommonMessage.NUMBER.getMessange()
                + ResultMessage.FOURTH.getDescription() + lottoResult.get(50000) + CommonMessage.NUMBER.getMessange()
                + ResultMessage.THIRD.getDescription() + lottoResult.get(1500000) + CommonMessage.NUMBER.getMessange()
                + ResultMessage.SECOND.getDescription() + lottoResult.get(30000000) + CommonMessage.NUMBER.getMessange()
                + ResultMessage.FIRST.getDescription() + lottoResult.get(2000000000) + CommonMessage.NUMBER.getMessange();
    }
}
