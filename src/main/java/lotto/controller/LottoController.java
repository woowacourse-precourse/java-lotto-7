package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoShop;
import lotto.model.Player;
import lotto.model.WinType;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final Player player;
    private final LottoShop lottoShop;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.player = Player.getInstance();
        this.lottoShop = new LottoShop();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startLotto() {
        inputUsingPrice();
        List<Lotto> lottos = buyLottos();
        outputView.printLottos(lottos);
        inputWinNumberAndBonusNumber();
        findWinLottos(lottos);
        player.calculateResult();
        outputView.printResult(player.getWinCount(), player.getPriceRatio());
    }

    private void inputWinNumberAndBonusNumber() {
        Set<Integer> winNumbers = inputWinNumbers();
        inputBonusNumber(winNumbers);
    }

    private void findWinLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            WinType winType = lottoShop.findWinLotto(lotto);
            addWinLotto(winType);
        }
    }

    private void addWinLotto(WinType winType) {
        if (winType != WinType.ZERO) {
            player.addWinCount(winType);
        }
    }

    private void inputUsingPrice() {
        int usingPrice = inputView.inputPrice();
        player.addUsingPrice(usingPrice);
    }

    private Set<Integer> inputWinNumbers() {
        Set<Integer> winNumbers = inputView.inputWinNumbers();
        lottoShop.setWinNumbers(winNumbers);
        return winNumbers;
    }

    private void inputBonusNumber(Set<Integer> winNumbers) {
        int bonusNumber = inputView.inputBonusNumber(winNumbers);
        lottoShop.setBonusNumber(bonusNumber);
    }

    private List<Lotto> buyLottos() {
        int count = player.getUsingPrice() / 1000;
        List<Lotto> lottos = lottoShop.buyLotto(count);
        return player.addLotto(lottos);
    }
}
