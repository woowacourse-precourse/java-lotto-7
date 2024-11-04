package lotto.controller;

import lotto.model.Consumer;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        // 로또 가격 입력 및 로또 생성
        Consumer consumer = new Consumer(InputView.getLottoCount());

        // 생성된 로또 출력
        OutputView.printLottoTicket(consumer);

        // 당첨 번호와 보너스 번호 입력 및 저장
        List<Integer> mainNumber = InputView.getWinningNumber();
        Integer bonusNumber = InputView.getBonusNumber(mainNumber);
        WinningNumber winningNumber = new WinningNumber(mainNumber, bonusNumber);

        // 당첨 통계 및 수익률 구하고 출력
        consumer.setLottoResult(winningNumber);
        OutputView.printResult(consumer);
    }
}