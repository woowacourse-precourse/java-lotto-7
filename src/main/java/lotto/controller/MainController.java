package lotto.controller;

import java.util.List;
import lotto.domain.CustomLottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.LottoDto;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 구입금액 입력
        Integer price = inputView.scanPrice();

        // 구매내역 출력
        LottoMachine lottoMachine = new LottoMachine(new CustomLottoGenerator());
        List<Lotto> purchasedLottos = lottoMachine.generateLottos(price);
        outputView.printLottoList(purchasedLottos.stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList());

        // 당첨 번호 입력
        Lotto winningLotto = new Lotto(inputView.scanWinningLotto()
                .getNumbers());

        // 보너스 번호 입력
        Integer bonusNumber = inputView.scanBonusNumber(new LottoDto(winningLotto.getNumbers()));

        // 당첨 통계 출력

    }
//
//    private void validateDuplicate(Lotto winningLotto, Integer bonusNumber) {
//        if (winningLotto.getNumbers().contains(bonusNumber)) {
//
//        }
//    }
//
//    public LottoStatistics calcStatistics(List<Lotto> purchasedLottos, Lotto WinningLotto, Integer bonusNumber) {
//        for (Lotto purchasedLotto : purchasedLottos) {
//            int matchCount = calcMatchCount(purchasedLotto, WinningLotto);
//            boolean isBonusNumberMatched = purchasedLotto.getNumbers().contains(bonusNumber);
//
//        }
//    }
//
//    public int calcMatchCount(Lotto purchasedLotto, Lotto winningLotto) {
//        return (int) winningLotto.getNumbers().stream()
//                .filter(purchasedLotto.getNumbers()::contains)
//                .count();
//    }
}
