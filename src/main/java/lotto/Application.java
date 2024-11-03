package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        LottoAmount lottoAmount = InputValidator.readAmount();

        int purchaseCount = lottoAmount.getAmount() / 1000;
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);

        LottoShop lottoShop = new LottoShop();
        List<Lotto> issuedLottoTickets = lottoShop.buyLottoTickets(lottoAmount);
        LottoPrinter.printLotto(issuedLottoTickets);

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = InputValidator.readWinningNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        LottoBonus lottoBonus = InputValidator.readBonusNumber(winningLotto);

        LottoStatistics lottoStatistics = new LottoStatistics();
        LottoResult lottoResult = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        LottoPrinter.printStatistics(lottoResult);
    }
}
