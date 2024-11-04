package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.readPurchaseAmount();
            List<Lotto> lottoTickets = LottoGenerator.generateLottos(purchaseAmount);
            OutputView.printLottoTickets(lottoTickets);

            WinningNumbers winningNumbers = InputView.readWinningNumbers();
            Result result = Result.calculateResult(lottoTickets, winningNumbers);
            OutputView.printResult(result, purchaseAmount);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            main(args); // 입력 오류 시 재시도
        }
    }
}