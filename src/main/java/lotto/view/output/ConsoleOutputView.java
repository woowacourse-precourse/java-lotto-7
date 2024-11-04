package lotto.view.output;

import lotto.dto.response.PurchasedLottosDTO;
import lotto.dto.response.WinningResultsDTO;
import lotto.view.output.util.OutputFormatter;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printError(String message) {
        System.out.println(message + "\n");
    }

    @Override
    public void printPurchasedLottos(PurchasedLottosDTO purchasedLottosDTO) {
        String purchaseCountMessage = OutputFormatter.formatPurchaseLottoCount(
                purchasedLottosDTO.purchasedLottoDTOs().size()
        );
        String lottoNumbersMessage = OutputFormatter.formatLottoNumbers(
                purchasedLottosDTO.purchasedLottoDTOs()
        );
        String output = purchaseCountMessage + lottoNumbersMessage;

        System.out.println(output);
    }

    @Override
    public void printWinningResults(WinningResultsDTO winningResultsDTO) {
        String resultPrefixMessage = OutputFormatter.formatResultPrefix();
        String winningResultsMessage = OutputFormatter.formatWinningResults(
                winningResultsDTO.winningResultDTOs()
        );
        String profitRateMessage = OutputFormatter.formatProfitRate(
                winningResultsDTO.profitRate()
        );
        String output = resultPrefixMessage + winningResultsMessage + profitRateMessage;

        System.out.println(output);
    }
}
