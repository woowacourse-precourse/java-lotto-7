package lotto.handler.rank.process;

import java.util.HashMap;
import java.util.List;
import lotto.handler.LottoHandler;
import lotto.handler.purchase.dto.LottosDTO;
import lotto.handler.purchase.process.Lotto;
import lotto.handler.purchase.process.WinningRank;
import lotto.handler.rank.dto.RankCountsDTO;
import lotto.handler.rank.dto.WinningNumberDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import lotto.utility.FormatConverter;

public class WinningRankHandler extends LottoHandler {
    private final RankCounter rankCounter;

    public WinningRankHandler(RankCounter rankCounter) {
        this.rankCounter = rankCounter;
    }

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        LottosDTO lottosDTO = getLottosDTOInHandlerToken(handlerToken);
        WinningNumberDTO winningNumbersDTO = getWinningNumberDTOInHandlerToken(handlerToken);

        HashMap<WinningRank, Integer> rankCounts = rankCounter.countRanks(getLottos(lottosDTO),
                getWinningNumbers(winningNumbersDTO), getBonusNumbers(winningNumbersDTO));

        handlerToken.addContent(TokenType.RANK_COUNTS_DTO, RankCountsDTO.create(rankCounts));
        return handlerToken;
    }

    private LottosDTO getLottosDTOInHandlerToken(HandlerToken handlerToken) {
        return handlerToken.getContent(TokenType.LOTTOS_DTO, LottosDTO.class);
    }

    private WinningNumberDTO getWinningNumberDTOInHandlerToken(HandlerToken handlerToken) {
        return handlerToken.getContent(TokenType.WINNING_NUMBER_DTO, WinningNumberDTO.class);
    }

    private List<Lotto> getLottos(LottosDTO lottosDTO) {
        return lottosDTO.getLottos();
    }

    private List<Integer> getWinningNumbers(WinningNumberDTO winningNumberDTO) {
        String winningNumbers = winningNumberDTO.getWinningNumbers();
        return FormatConverter.convertStringToInteger(winningNumbers);
    }

    private int getBonusNumbers(WinningNumberDTO winningNumberDTO) {
        String bonusNumber = winningNumberDTO.getBonusNumber();
        return Integer.parseInt(bonusNumber);
    }
}
