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
        List<Integer> winningLotto = inputView.scanWinningLotto();
        System.out.println(winningLotto);

        // 보너스 번호 입력
        Integer bonusNumber = inputView.scanBonusNumber();
        System.out.println(bonusNumber);
    }
}
