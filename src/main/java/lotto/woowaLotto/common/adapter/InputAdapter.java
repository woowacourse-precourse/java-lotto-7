package lotto.woowaLotto.common.adapter;

import lotto.woowaLotto.common.adapter.parser.BonusNumberParser;
import lotto.woowaLotto.common.adapter.parser.LottoParser;
import lotto.woowaLotto.common.adapter.parser.PriceParser;
import lotto.woowaLotto.common.ui.input.Input;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.Lotto;

public class InputAdapter {

    private final LottoParser lottoParser = new LottoParser();
    private final PriceParser priceParser = new PriceParser();
    private final BonusNumberParser bonusNumberParser = new BonusNumberParser();
    private final Input input;

    public InputAdapter(Input Input) {
        this.input = Input;
    }

    public Lotto inputLotto() {
        return lottoParser.parse(input.inputPickedNum());
    }

    public int inputBonusNum(){
        return bonusNumberParser.parse(input.inputBonusNum());
    }

    public int inputPrice() {
        return priceParser.parse(input.inputLottoPrice());
    }
}
