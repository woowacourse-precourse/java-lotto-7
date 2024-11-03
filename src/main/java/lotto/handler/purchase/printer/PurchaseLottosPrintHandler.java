package lotto.handler.purchase.printer;

import java.util.List;
import lotto.display.DisplayFormat;
import lotto.handler.LottoHandler;
import lotto.handler.purchase.dto.LottosDTO;
import lotto.handler.purchase.process.Lotto;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class PurchaseLottosPrintHandler extends LottoHandler {

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        LottosDTO lottosDTO = handlerToken.getContent(TokenType.LOTTOS_DTO, LottosDTO.class);
        List<Lotto> lottos = lottosDTO.getLottos();
        printLottos(lottos);
        return handlerToken;
    }

    private void printLottos(List<Lotto> lottos) {
        System.out.print(DisplayFormat.GAP.displayDefault());
        System.out.print(DisplayFormat.PURCHASE_INPUT_RESULT.displayWithOneValue(lottos.size()));
        lottos.forEach(lotto -> System.out.println(lotto.getDisplayNumbers()));
        System.out.print(DisplayFormat.GAP.displayDefault());
    }
}
