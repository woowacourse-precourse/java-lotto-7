package lotto.model;

import lotto.dto.LottoResultDto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class WinningResult {
    enum Result {
        FIRST(6, 2000000000),
        SECOND(5, 30000000),
        THIRD(5, 1500000),
        FOURTH(4, 50000),
        FIFTH(3, 5000);

        private int matchCount;
        private int money;

        Result(int matchCount, int money) {
            this.matchCount = matchCount;
            this.money = money;
        }
    }

    EnumMap<Result, Integer> winningResult = new EnumMap<>(Result.class);

    public WinningResult() {
        for (Result result : Result.values()) {
            winningResult.put(result, 0);
        }
    }

    /**
     * soldLottos에서 구매한 로또 번호들을 꺼내고
     * winningLottos(당첨 번호) 와 각각의 번호를 대조하여 맞춘 갯수를 센다.
     * 5개 맞춘 번호들은 추가적으로 bonusNumber(보너스 번호)도 맞는지 확인하여 2등과 3등을 구분한다.
     */
    public void calculateWinningResult(List<List<Integer>> soldLottos, List<Integer> winningLottos, int bonusNumber) {
        for (List<Integer> soldLotto : soldLottos) {
            int matchCount = matchCount(soldLotto, winningLottos);
            boolean matchBonusNumber = matchBonusNumber(soldLotto, bonusNumber);

            saveResult(matchCount, matchBonusNumber);
        }
    }

    public double getReturnResult(int purchaseMoney) {
        long totalMoney = 0L;
        for (Result result : Result.values()) {
            totalMoney += (long) result.money * winningResult.get(result);
        }
        return ((double) totalMoney / purchaseMoney) * 100;
    }

    public List<LottoResultDto> getWinningResult() {
        List<LottoResultDto> lottoResult = new ArrayList<>();
        for (Result result : Result.values()) {
            boolean isBonusMatch = (result == Result.SECOND);
            lottoResult.add(new LottoResultDto(
                    result.matchCount,
                    result.money,
                    winningResult.get(result),
                    isBonusMatch
            ));
        }
        return lottoResult;
    }

    //getResult()에서 구매한 로또번호 6개를 넘겨주면 당첨 번호와 맞는 갯수를 리턴한다.
    private int matchCount(List<Integer> soldLotto, List<Integer> winningLottos) {
        int matchCount = 0;
        for (int soldNumber : soldLotto) {
            if (winningLottos.contains(soldNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean matchBonusNumber(List<Integer> soldLotto, int bonusNumber) {
        return soldLotto.contains(bonusNumber);
    }

    private void saveResult(int matchCount, boolean matchBonusNumber) {
        if (matchCount == 6) {
            winningResult.put(Result.FIRST, winningResult.get(Result.FIRST) + 1);
            return;
        }
        if (matchCount == 5 && matchBonusNumber) {
            winningResult.put(Result.SECOND, winningResult.get(Result.SECOND) + 1);
            return;
        }
        if (matchCount == 5) {
            winningResult.put(Result.THIRD, winningResult.get(Result.THIRD) + 1);
            return;
        }
        if (matchCount == 4) {
            winningResult.put(Result.FOURTH, winningResult.get(Result.FOURTH) + 1);
            return;
        }
        if (matchCount == 3) {
            winningResult.put(Result.FIFTH, winningResult.get(Result.FIFTH) + 1);
        }
    }
}
