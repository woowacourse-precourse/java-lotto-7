package lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto;

import lotto.woowaLotto.common.adapter.InputAdapter;
import lotto.woowaLotto.common.ui.input.AutoLottoInput;
import lotto.woowaLotto.common.ui.output.Output;
import lotto.woowaLotto.lottoPlayer.woowaLotto.WooWaLotto;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.AutoLottoHandler;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.Lotto;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.LottoResult;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.Lottos;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.PickedLotto;

public class WooWaAutoLotto implements WooWaLotto {

    private final InputAdapter inputAdapter = new InputAdapter(new AutoLottoInput());
    private final AutoLottoHandler autoLottoHandler = new AutoLottoHandler();
    private final Output output = new Output();

    @Override
    public void draw() {
        int price = getInputPrice();
        Lottos lottos = autoLottoHandler.getRandomLottos(price);
        PickedLotto pickedLotto = getPickedLotto();
        LottoResult result = autoLottoHandler.getResult(lottos, pickedLotto, price);

        output.printResult(result);
    }

    private int getInputPrice() {
        return inputAdapter.inputPrice();
    }

    private PickedLotto getPickedLotto() {
        Lotto pickedLottoNums = inputAdapter.inputLotto();
        int bonusNum = inputAdapter.inputBonusNum();
        return new PickedLotto(pickedLottoNums, bonusNum);
    }
}