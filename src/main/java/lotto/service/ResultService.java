package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.model.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultService {
    // 사용자 로또와 당첨 번호를 비교하여 결과 계산
    public Result calculateResult(List<Lotto> userLottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = setResult();

        for (Lotto lotto : userLottos) {
            Rank rank = Rank.valueOf(lotto, winningLotto);
            result.put(rank, result.get(rank) + 1);
        }

        int totalPrize = calculateTotalPrize(result);
        double profitRate = calculateProfitRate(totalPrize, userLottos.size() * LottoService.PRICE);

        return new Result(result, profitRate, totalPrize);
    }

    // 각 Rank에 대한 초기 결과 설정
    private Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        return result;
    }

    // 총 상금을 계산
    private int calculateTotalPrize(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    // 수익률 계산
    private double calculateProfitRate(int totalPrize, int totalSpent) {
        if (totalSpent == 0) //0으로 나누는 경우 처리
            return 0;

        return (double) totalPrize / totalSpent * 100;
    }
}
