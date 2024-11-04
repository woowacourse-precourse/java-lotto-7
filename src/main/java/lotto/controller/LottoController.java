package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.lotto.Lottos;
import lotto.model.parseLotto.ParseLotto;
import lotto.view.InputView;
import lotto.view.OutView;

public class LottoController {

    private String winNumbersStr;

    private Integer buyAmount;
    private List<String> winNumbers;
    private Integer bonusNumber;

    public LottoController() {
        //입출력 로직
        rerunTemplate(() -> {
            buyAmount = InputView.inputBuyAmount();
        });

        rerunTemplate(() -> {
            winNumbersStr = InputView.inputWinNumbers();
            winNumbers = ParseLotto.splitWinNumber(winNumbersStr);
        });

    }

    public void run() {

        //로또 발행
        Lottos lottos = generateLottos();
        lottos.generateLotto();
        lottos.lottosSort();

        //발행한 로또 출력
        OutView.generatedLottoPrint(lottos.getLottosCount(), lottos);

        lottos.getWinstatus().checkWin(lottos);

        OutView.winStatusPrint(lottos);

        lottos.calculateProfitRate();

        OutView.profitRatePrint(lottos.getProfitRate());


    }

    private Lottos generateLottos() {
        return rerunTemplate(() -> {

            bonusNumber = InputView.inputBonusNumber();


            return new Lottos(winNumbers,buyAmount,bonusNumber);
        });
    }

    private <T> T rerunTemplate(final Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                OutView.printErrorMessage(e.getMessage());
            }
        }
    }


    private void rerunTemplate(final Runnable action) {
        while (true) {
            try {
                action.run();
                break;
            } catch (IllegalArgumentException e) {
                OutView.printErrorMessage(e.getMessage());
            }
        }
    }

}
