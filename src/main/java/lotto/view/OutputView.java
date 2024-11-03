package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRank;

import java.util.Map;

public class OutputView {
    private static final String RESULT_HEADER = "당첨 통계";
    private static final String RESULT_DELIMITER = "---";
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String RANK_BOARD_RENDER_FORMAT = "%s (%,d원) - %d개";
    private static final String RATE_OF_RETURN_RENDER_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void renderErrorMessage(final String message) {
        System.out.println(message);
        System.out.println();
    }

    public void renderNewLine() {
        System.out.println();
    }

    public void renderGeneratedLottos(final LottoGame lottoGame) {
        renderNewLine();
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE, lottoGame.getLottoCount());
        renderNewLine();
        lottoGame.getGeneratedLottos().forEach(this::renderLotto);
    }

    public void renderLotto(final Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void renderResult(final Map<LottoRank, Integer> lottoRankBoard, final double rateOfReturn) {
        renderNewLine();
        renderResultHeader();
        lottoRankBoard.forEach(this::renderRankBoard);
        renderRateOfReturn(rateOfReturn);
    }

    private void renderResultHeader() {
        System.out.println(RESULT_HEADER);
        System.out.println(RESULT_DELIMITER);
    }

    private void renderRankBoard(final LottoRank lottoRank, final Integer count) {
        if (lottoRank != LottoRank.NONE)
            System.out.printf(RANK_BOARD_RENDER_FORMAT, lottoRank.getDescription(), lottoRank.getPrizeMoney(), count);
        renderNewLine();
    }

    private void renderRateOfReturn(final double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_RENDER_FORMAT, rateOfReturn);
    }

}
