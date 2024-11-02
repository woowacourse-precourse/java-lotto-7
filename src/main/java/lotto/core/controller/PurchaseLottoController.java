package lotto.core.controller;

import java.util.List;
import lotto.commons.command.Command;
import lotto.commons.handler.Handler;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.service.CreateLottoPurchaseAmountService;
import lotto.core.service.PublishLottoService;
import lotto.core.view.InputLottoPurchaseAmountView;
import lotto.core.view.PublishLottoView;

public class PurchaseLottoController implements Controller<Void, List<LottoDto>> {

    private final InputLottoPurchaseAmountView inputLottoPurchaseAmountView;

    private final PublishLottoView publishLottoView;

    private final CreateLottoPurchaseAmountService createLottoPurchaseAmountService;

    private final PublishLottoService publishLottoService;

    public PurchaseLottoController(InputLottoPurchaseAmountView inputLottoPurchaseAmountView,
                                   PublishLottoView publishLottoView,
                                   CreateLottoPurchaseAmountService createLottoPurchaseAmountService,
                                   PublishLottoService publishLottoService) {
        this.inputLottoPurchaseAmountView = inputLottoPurchaseAmountView;
        this.publishLottoView = publishLottoView;
        this.createLottoPurchaseAmountService = createLottoPurchaseAmountService;
        this.publishLottoService = publishLottoService;
    }

    @Override
    public List<LottoDto> request(Void unused) {
        LottoPurchaseAmountDto amount = this.processInputLottoPurchaseAmount();
        List<LottoDto> data = this.processPublishLotto(amount);
        this.displayPublishedLotto(data);
        return data;
    }

    private LottoPurchaseAmountDto processInputLottoPurchaseAmount() {
        LottoPurchaseAmountDto amount;
        do {
            amount = Handler.runCatching(() -> {
                this.inputLottoPurchaseAmountView.display("구매금액을 입력해 주세요.");
                String read = Command.read();
                return this.createLottoPurchaseAmountService.create(read);
            });
        } while (amount == null);
        return amount;
    }

    private List<LottoDto> processPublishLotto(LottoPurchaseAmountDto amount) {
        return this.publishLottoService.publish(amount);
    }

    private void displayPublishedLotto(List<LottoDto> data) {
        this.publishLottoView.display(data);
    }
}
