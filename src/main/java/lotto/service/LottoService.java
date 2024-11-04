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
        DecimalFormat formatter = new DecimalFormat("#,###");
        StringBuilder stringBuilder = new StringBuilder();
        for(WinningResult rank : WinningResult.values()){
            stringBuilder.append(rank.getMatchNumberCount()).append("개 일치").append("(")
                    .append(formatter.format(rank.getPrize())).append("원)").append(" - ")
                    .append(countWinningResult(results, rank)).append("개")
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public int countWinningResult(List<WinningResult> results, WinningResult rank) {
        return results.stream()
                .collect(Collectors.groupingBy(result -> result, Collectors.counting()))
                .getOrDefault(rank, 0L)
                .intValue();
    }
}
