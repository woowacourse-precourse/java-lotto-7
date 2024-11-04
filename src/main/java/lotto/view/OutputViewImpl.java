package lotto.view;

import java.text.NumberFormat;
import lotto.dto.lottoDto.LottoResponse;
import lotto.dto.lottoWinningResultDto.LottoWinningResult;
import lotto.dto.lottoWinningResultDto.LottoWinningResultResponse;
import lotto.message.OutputMessage;
import lotto.model.Lotto;

public class OutputViewImpl implements OutputView {
    @Override
    public void printIssuedLotto(LottoResponse lottoResponse) {
        System.out.println(lottoResponse.lottoCount() + OutputMessage.ISSUED_LOTTO_MESSAGE.getOutputMessage());
        for (Lotto lotto : lottoResponse.issuedLotto()) {
            System.out.println(lotto.toString());
        }
    }

    @Override
    public void printLottoResult(LottoWinningResultResponse response) {
        LottoWinningResult winningResult = response.lottoWinningResult();

        System.out.println(OutputMessage.WINNING_STATISTICS.getOutputMessage());

        printThreeMatches(winningResult.fifthPlaceNumber());
        printFourMatches(winningResult.fourthPlaceNumber());
        printFiveMatches(winningResult.thirdPlaceNumber());
        printFiveAndBonusBallMatches(winningResult.secondPlaceNumber());
        printSixMatches(winningResult.firstPlaceNumber());

        printRateOfReturn(response.winningAmount());
    }

    private void printThreeMatches(int lottoResult) {
        System.out.println(
                OutputMessage.THREE_MATCHES_MESSAGE.getOutputMessage() + lottoResult
                        + OutputMessage.MATCHES_MESSAGE_SUFFIX.getOutputMessage());
    }

    private void printFourMatches(int lottoResult) {
        System.out.println(
                OutputMessage.FOUR_MATCHES_MESSAGE.getOutputMessage() + lottoResult
                        + OutputMessage.MATCHES_MESSAGE_SUFFIX.getOutputMessage());
    }

    private void printFiveAndBonusBallMatches(int lottoResult) {
        System.out.println(
                OutputMessage.FIVE_AND_BONUS_BALL_MATCHES_MESSAGE.getOutputMessage() + lottoResult
                        + OutputMessage.MATCHES_MESSAGE_SUFFIX.getOutputMessage());
    }

    private void printFiveMatches(int lottoResult) {
        System.out.println(
                OutputMessage.FIVE_MATCHES_MESSAGE.getOutputMessage() + lottoResult
                        + OutputMessage.MATCHES_MESSAGE_SUFFIX.getOutputMessage());
    }

    private void printSixMatches(int lottoResult) {
        System.out.println(
                OutputMessage.SIX_MATCHES_MESSAGE.getOutputMessage() + lottoResult
                        + OutputMessage.MATCHES_MESSAGE_SUFFIX.getOutputMessage());
    }

    private void printRateOfReturn(double rateOfReturn) {
        NumberFormat f = NumberFormat.getInstance();
        f.setGroupingUsed(false);

        System.out.println(OutputMessage.RATE_OF_RETURN_MESSAGE_PREFIX.getOutputMessage()
                + rateOfReturn
                + OutputMessage.RATE_OF_RETURN_MASSAGE_SUFFIX.getOutputMessage());
    }
}
