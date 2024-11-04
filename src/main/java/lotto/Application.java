package lotto;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.io.InputReader;
import lotto.io.OutputWriter;
import lotto.strategy.LotteryNumberGenerator;

public class Application {
    public static void main(String[] args) {

        OutputWriter.message("구입금액을 입력해 주세요.");
        int purchaseAmount = InputReader.totalPurchaseAmount();
        OutputWriter.addBlankLine();

        OutputWriter.message(purchaseAmount + "개를 구매했습니다.");
        List<List<Integer>> issuedNumbers = LotteryNumberGenerator.generateNumbers(purchaseAmount);
        OutputWriter.issuedNumbers(issuedNumbers);
        OutputWriter.addBlankLine();

        OutputWriter.message("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = InputReader.winningNumbers();
        OutputWriter.addBlankLine();

        OutputWriter.message("보너스 번호를 입력해 주세요.");
        int bonusNumber = InputReader.bonusNumber(winningNumbers);
        OutputWriter.addBlankLine();

        List<Lotto> tickets = issuedNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        OutputWriter.message("당첨 통계");
        OutputWriter.message("---");

        LottoCalculator calculator = new LottoCalculator();
        calculator.calculateResults(tickets,winningNumbers,bonusNumber);

        OutputWriter.lottoCalculateResults(calculator.results());
        OutputWriter.profitRate(calculator.profitRate(purchaseAmount*1000));

    }
}
