package lotto.handler.statistics.printer;

import lotto.display.DisplayFormat;
import lotto.handler.LottoHandler;
import lotto.handler.statistics.dto.ProfitRateDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class StatisticsPrinterHandler extends LottoHandler {

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        ProfitRateDTO profitRateDTO = getProfitRateDTOInHandlerToken(handlerToken);
        System.out.print(DisplayFormat.STATISTICS.displayWithOneValue(profitRateDTO.getProfitRate()));
        return handlerToken;
    }

    private ProfitRateDTO getProfitRateDTOInHandlerToken(HandlerToken handlerToken) {
        return handlerToken.getContent(TokenType.PROFIT_RATE_DTO, ProfitRateDTO.class);
    }
}
