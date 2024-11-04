package lotto.service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoMachine;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;

public class LottoService {
    public void makeLotto(int count) {
        LottoMachine machine = LottoMachine.getInstance();
        machine.createLottos(count);
    }

    public void printLottoNumbers() {
        LottoMachine machine = LottoMachine.getInstance();
        machine.printAllLottoNumbers();
    }

    public void makeWinningLotto(List<Integer> numbers, int bonusNumber) {
        LottoMachine machine = LottoMachine.getInstance();
        machine.createWinningNumbers(numbers, bonusNumber);
    }

    public List<WinningResult> countLottoMatchNumbers(List<Integer> numbers, int bonusNumber) {
        WinningNumbers winningNumbers = WinningNumbers.getInstance(numbers, bonusNumber);
         return winningNumbers.matchWinningNumbers();
    }

    public String toStringResult(List<WinningResult> results) {
        StringBuilder stringBuilder = new StringBuilder();

        for (WinningResult rank : WinningResult.values()) {
            stringBuilder.append(formatRankInfo(rank, results));
        }

        return stringBuilder.toString();
    }

    private String formatRankInfo(WinningResult rank, List<WinningResult> results) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchNumberCount()).append("개 일치");

        // 보너스 볼 일치 여부에 따른 처리
        if (rank.isMatchBonusNumber()) {
            sb.append(", 보너스 볼 일치 ");
        }

        sb.append("(").append(formatter.format(rank.getPrize())).append("원) - ")
                .append(countWinningResult(results, rank)).append("개\n");

        return sb.toString();
    }


    public int countWinningResult(List<WinningResult> results, WinningResult rank) {
        return results.stream()
                .collect(Collectors.groupingBy(result -> result, Collectors.counting()))
                .getOrDefault(rank, 0L)
                .intValue();
    }
}
