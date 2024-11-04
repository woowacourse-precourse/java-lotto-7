package lotto;


import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int DEFAULT_LOTTO_AMOUNT = 1000;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int amount = inputView.buyLotto();
        int count = getLottoCount(amount);

        Lottos lottos = generateLottos(count);
        outputView.printLottoPurchaseDetails(lottos);

        WinningLotto winningLotto = createWinningLottoFromInput();

    }

    private int getLottoCount(int amount) {
        int count = amount / DEFAULT_LOTTO_AMOUNT;

        return count;
    }

    private Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        while(count > 0) {
            Lotto lotto = new Lotto(LottoNumber.generate());

            lottos.add(lotto);
            count -= 1;
        }

        return new Lottos(lottos);
    }

    private WinningLotto createWinningLottoFromInput() {
        String input = inputView.enterWinningNumbers();
        int bonusNumber = inputView.enterBonusNumber();
        List<Integer> winningNumbers = NumberParser.split(input);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

}
