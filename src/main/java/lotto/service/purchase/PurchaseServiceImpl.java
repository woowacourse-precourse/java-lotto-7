package lotto.service.purchase;

import lotto.domain.DrawTool;
import lotto.domain.LottoMachine;
import lotto.service.constant.Cost;
import lotto.service.input.InputService;

public class PurchaseServiceImpl implements PurchaseService {

    private static PurchaseServiceImpl instance;
    private final Long purchaseAmount;

    private PurchaseServiceImpl(InputService<Long> inputService) {
        purchaseAmount = inputService.get();
    }

    @Override
    public DrawTool openTrade() {
        return new LottoMachine(getBetSlip());
    }

    private Long getBetSlip() {
        return purchaseAmount / Cost.ONE_LOTTO_GAME.getCost();
    }

    public static PurchaseServiceImpl getTrade(InputService<Long> inputService) {
        if(instance == null) {
            instance = new PurchaseServiceImpl(inputService);
        }
        return instance;
    }
}