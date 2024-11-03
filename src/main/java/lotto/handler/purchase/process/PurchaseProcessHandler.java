package lotto.handler.purchase.process;

import java.util.ArrayList;
import java.util.List;
import lotto.handler.LottoHandler;
import lotto.handler.purchase.dto.LottosDTO;
import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class PurchaseProcessHandler extends LottoHandler {
    private static final int LOTTO_AMOUNT = 1000;
    private final LottoGenerator lottoGenerator;

    public PurchaseProcessHandler(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        int purchasedlottosCount = getLottosCount(handlerToken);
        List<Lotto> lottos = generateLottos(purchasedlottosCount);
        LottosDTO lottosDTO = LottosDTO.create(lottos);
        handlerToken.addContent(TokenType.LOTTOS_DTO, lottosDTO);
        return handlerToken;
    }

    private int getLottosCount(HandlerToken handlerToken) {
        PurchaseAmountDTO purchaseAmountDTO = handlerToken.getContent(TokenType.PURCHASE_AMOUNT_DTO,
                PurchaseAmountDTO.class);
        int purchaseAmount = Integer.parseInt(purchaseAmountDTO.getPurchaseAmount());
        return purchaseAmount / LOTTO_AMOUNT;
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }
}
