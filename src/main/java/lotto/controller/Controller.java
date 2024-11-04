package lotto.controller;

import lotto.domain.LottoRank;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputVIew;

import java.util.Map;

public class Controller {
    InputView inputView = new InputView();
    OutputVIew outputVIew = new OutputVIew();

    public void run() {
        try {
            User user = new User(inputView.inputPayment());
            printLottoInfo(user);

            WinningLotto winningLotto = new WinningLotto(
                    inputView.inputWinningLottoNumber(),
                    inputView.inputBonusNumber()
            );
            printWinningInformation(user, winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printLottoInfo(User user) {
        outputVIew.printLottoQuantityMessage(user.getLottoNumbers());
        outputVIew.printLottNumbers(user.getLottoPapers());
    }

    void printWinningInformation(User user, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankingCounts = winningLotto.countLottoRankings(user.getLottoPapers());
        outputVIew.printStatisticsMessage();
        outputVIew.printWinningLottoQuantity(rankingCounts);

        long totalWinnings = winningLotto.calculateTotalWinnings(rankingCounts);
        double rate = winningLotto.calculateRate(
                totalWinnings,
                user.getPayment()
        );
        outputVIew.printRatioOfReturn(rate);
    }
}
