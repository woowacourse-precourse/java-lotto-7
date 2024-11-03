package lotto.handler.statistics.printer;

import lotto.display.DisplayFormat;
import lotto.handler.LottoHandler;
import lotto.handler.statistics.dto.ProfitRateDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class StatisticsPrinterHandler extends LottoHandler {

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        ProfitRateDTO profitRateDTO = handlerToken.getContent(TokenType.PROFIT_RATE_DTO, ProfitRateDTO.class);
        String profitRate = profitRateDTO.getProfitRate();
        System.out.print(DisplayFormat.STATISTICS.displayWithOneValue(profitRate));
        return handlerToken;
    }
}
