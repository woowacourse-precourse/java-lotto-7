package lotto.core.controller;

import lotto.commons.command.Command;
import lotto.commons.handler.Handler;
import lotto.commons.lang.InputOverFlowException;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.dto.LottoTicketDto;
import lotto.core.service.CreateLottoPurchaseAmountService;
import lotto.core.service.PublishLottoTicketService;
import lotto.core.view.InputLottoPurchaseAmountView;
import lotto.core.view.PublishLottoTicketView;

public class PurchaseLottoController implements Controller<Void, LottoTicketDto> {

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
    public LottoTicketDto request(Void unused) {
        LottoPurchaseAmountDto amount = this.processInputLottoPurchaseAmount();
        LottoTicketDto ticket = this.processPublishLotto(amount);
        this.displayPublishedLotto(ticket);
        return ticket;
    }

    private LottoPurchaseAmountDto processInputLottoPurchaseAmount() {
        LottoPurchaseAmountDto amount;
        this.inputLottoPurchaseAmountView.display("구매금액을 입력해 주세요.");
        int count = 0;
        do {
            amount = Handler.runCatching(() -> {
                String read = Command.read();
                return this.createLottoPurchaseAmountService.create(read);
            });
            if (++count > 5) {
                throw new InputOverFlowException();
            }
        } while (amount == null);
        return amount;
    }

    private LottoTicketDto processPublishLotto(LottoPurchaseAmountDto amount) {
        return this.publishLottoTicketService.publish(amount);
    }

    private void displayPublishedLotto(LottoTicketDto ticket) {
        this.publishLottoTicketView.display(ticket);
    }
}
