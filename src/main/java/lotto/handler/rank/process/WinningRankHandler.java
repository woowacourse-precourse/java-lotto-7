package lotto.handler.rank.process;

import java.util.List;
import lotto.handler.LottoHandler;
import lotto.handler.purchase.dto.LottosDTO;
import lotto.handler.purchase.process.Lotto;
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
        LottosDTO lottosDTO = handlerToken.getContent(TokenType.LOTTOS_DTO, LottosDTO.class);
        WinningNumberDTO winningNumbersDTO = handlerToken.getContent(TokenType.WINNING_NUMBER_DTO,
                WinningNumberDTO.class);

        List<Lotto> lottos = getLottos(lottosDTO);
        List<Integer> winningNumbers = getWinningNumbers(winningNumbersDTO);
        int bonusNumber = getBonusNumbers(winningNumbersDTO);

        RankCountsDTO rankCountsDTO = RankCountsDTO.create(rankCounter.countRanks(lottos, winningNumbers, bonusNumber));
        handlerToken.addContent(TokenType.RANK_COUNTS_DTO, rankCountsDTO);
        return handlerToken;
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
