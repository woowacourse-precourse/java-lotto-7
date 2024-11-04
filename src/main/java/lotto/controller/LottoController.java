package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoStore;
import lotto.utils.StringConvertor;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Integer payMoney = repeatUntilReadValidInput(this::receivePayMoney);
        List<Lotto> purchasedLotto = purchaseLottos(payMoney);
        List<Integer> winLottoNumbers = receiveWinLottoNumbers();
        Integer winBonusNumber = receiveWinBonusNumber();
        announceResult(purchasedLotto, winLottoNumbers, winBonusNumber);
    }

    public List<Lotto> purchaseLottos(Integer payMoney) {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> purchasedLottos = lottoStore.orderLottos(payMoney);
        outputView.printLottoCount(purchasedLottos.size());
        outputView.printPurchasedLotto(purchasedLottos);
        return purchasedLottos;
    }

    public void announceResult(List<Lotto> purchasedLotto, List<Integer> winLottoNumbers, Integer winBonusNumber) {
        LottoResult lottoResult = new LottoResult(purchasedLotto, winLottoNumbers, winBonusNumber);

        outputView.printLottoStatistics(lottoResult.getStatistics(), lottoResult.getProfitRate());
    }

    private List<Integer> receiveWinLottoNumbers() {
        outputView.requestInputLottoNumber();
        return StringConvertor.toLottoNumbers(inputView.inputWinLottoNumbers());
    }

    private Integer receiveWinBonusNumber() {
        outputView.requestInputBonusNumber();
        return StringConvertor.toInt(inputView.inputWinBonusNumber());
    }

    private Integer receivePayMoney() {
        outputView.requestInputPayMoney();
        return StringConvertor.toInt(inputView.inputPayMoney());
    }

    private <T> T repeatUntilReadValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

}
