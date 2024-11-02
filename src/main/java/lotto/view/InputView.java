package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.dto.request.LottoAmountRequest;
import lotto.dto.response.LottoesResponse;
import lotto.util.Container;
import lotto.util.LottoAmountValidator;

public class InputView {

    private final LottoAmountValidator lottoAmountValidator;
    private final LottoController lottoController;

    public InputView() {
        this.lottoAmountValidator = Container.getInstance(LottoAmountValidator.class);
        this.lottoController = Container.getInstance(LottoController.class);
    }

    public int setLottoPrice() {
        String price = Console.readLine();
        return lottoAmountValidator.validate(price);
    }

    public LottoesResponse setLottoes(int amount) {
        return lottoController.makeLottoes(LottoAmountRequest.from(amount));
    }
}