package lotto;

public class Application {
    public static void main(String[] args) {

        LottoTickets myTickets = LotteryStore.purchase();

        Lotto winningLotto = LottoDraw.inputWinningNumbers();
        winningLotto.bonusNumber = LottoDraw.inputBonusNumber(winningLotto);

        LottoResult result = new LottoResult();
        result.calculateResults(myTickets.getTickets(), winningLotto, winningLotto.bonusNumber);
        result.displayResults();

    }
}
