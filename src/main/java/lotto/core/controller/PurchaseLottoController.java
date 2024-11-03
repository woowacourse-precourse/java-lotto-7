package lotto.core.controller;

import lotto.commons.util.Command;
import lotto.commons.util.Repeat;
import lotto.core.constants.InputViewHeader;
import lotto.core.controller.request.VoidRequest;
import lotto.core.controller.response.PurchaseLottoResponse;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.dto.LottoTicketDto;
import lotto.core.service.CreateLottoPurchaseAmountService;
import lotto.core.service.PublishLottoTicketService;
import lotto.core.view.InputLottoPurchaseAmountView;
import lotto.core.view.PublishLottoTicketView;

public class PurchaseLottoController implements Controller<VoidRequest, PurchaseLottoResponse> {

    private final InputLottoPurchaseAmountView inputLottoPurchaseAmountView;

    private final PublishLottoTicketView publishLottoTicketView;

    private final CreateLottoPurchaseAmountService createLottoPurchaseAmountService;

    private final PublishLottoTicketService publishLottoTicketService;

    public PurchaseLottoController(InputLottoPurchaseAmountView inputLottoPurchaseAmountView,
                                   PublishLottoTicketView publishLottoTicketView,
                                   CreateLottoPurchaseAmountService createLottoPurchaseAmountService,
                                   PublishLottoTicketService publishLottoTicketService) {
        this.inputLottoPurchaseAmountView = inputLottoPurchaseAmountView;
        this.publishLottoTicketView = publishLottoTicketView;
        this.createLottoPurchaseAmountService = createLottoPurchaseAmountService;
        this.publishLottoTicketService = publishLottoTicketService;
    }

    @Override
    public PurchaseLottoResponse request(VoidRequest unused) {
        LottoPurchaseAmountDto amount = this.processInputLottoPurchaseAmount();
        LottoTicketDto ticket = this.publishLottoTicketService.publish(amount);
        this.publishLottoTicketView.display(ticket);
        return PurchaseLottoResponse.dtoOf(ticket);
    }

    private LottoPurchaseAmountDto processInputLottoPurchaseAmount() {
        this.inputLottoPurchaseAmountView.display(InputViewHeader.IN_LOTTO_PURCHASE_AMOUNT_VIEW);
        return Repeat.doWhile(5, () -> {
            String read = Command.read();
            return this.createLottoPurchaseAmountService.create(read);
        });
    }
}
