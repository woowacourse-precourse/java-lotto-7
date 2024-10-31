package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessage;
import lotto.LottoGenerator;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int money = lottoMoneyInput();

        int lottoCnt = money / LOTTO_PRICE;
        // 로또 발행
        List<Lotto> tmpLottos = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        for (int cnt = 0; cnt < lottoCnt; cnt++) {
            List<Integer> numbers = lottoGenerator.randomGenerate(1, 45, 6);
            tmpLottos.add(new Lotto(numbers));
        }
        Lottos lottos = new Lottos(tmpLottos);
        outputView.showHowManyLotto(lottos);
        outputView.showAllLottoNums(lottos);
    }

    private int lottoMoneyInput() {
        int money;
        while (true) {
            try {
                money = inputView.lottoMoneyInput();
                validateIsRightNumber(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        return money;
    }

    private void validateIsRightNumber(int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_DIVIDE_PRICE.getMsg());
        }
    }
}
