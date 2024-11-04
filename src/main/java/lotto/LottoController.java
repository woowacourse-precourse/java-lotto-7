package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoGenerator lottoGenerator;

    public LottoController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public int getPurchaseAmount() {
        return Integer.parseInt(inputView.readPurchaseAmount());
    }

    public List<Integer> getWinningNumbers() {
        String winningNumbers = inputView.readWinningNumbers();
        return StringParser.parseStringToWinningNumbers(winningNumbers);
    }

    public int getBonusNumber() {
        String bonusNumber = inputView.readBonusNumber();
        return Integer.parseInt(bonusNumber);
    }

    public List<Lotto> buyLotties(){
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lotties = lottoGenerator.generate(purchaseAmount);
        outputView.showLotties(lotties);
        return lotties;
    }

    public List<Rank> draw(List<Lotto> lotties) {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        LottoService lottoService = new LottoService(winningNumbers, bonusNumber);
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lotties) {
            Rank rank = lottoService.match(lotto);
            ranks.add(rank);
        }

        return ranks;
    }

    public void run() {
        List<Lotto> lotties = buyLotties();
        List<Rank> ranks = draw(lotties);
        outputView.showResult(ranks);
    }
}
