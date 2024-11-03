package lotto.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import lotto.Lotto;
import lotto.constant.ErrorMessage;
import lotto.constant.WinningRank;
import lotto.service.CalculateProfitRateService;
import lotto.service.LottoMatchNumberService;
import lotto.service.LottoNumberGeneratorService;
import lotto.service.LottoTicketBuyingService;
import lotto.service.LottoTicketIssueService;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoController {
    private final InputView inputView;
    private final OutPutView outPutView;
    private static final List<Integer> winningNumbers = new ArrayList<>();

    public LottoController(InputView inputView, OutPutView outPutView) {
        this.inputView = inputView;
        this.outPutView = outPutView;
    }

    public void run() {
        try {
            String buyingPrice = inputView.startLottoGameAndReadBuyingPrice();
            Integer lottoTicketAmount = LottoTicketBuyingService.buyingLottoTicket(buyingPrice);

            LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
            LottoTicketIssueService lottoTicketIssueService = new LottoTicketIssueService(lottoTicketAmount,
                    lottoNumberGeneratorService);
            List<Lotto> issuedLotto = lottoTicketIssueService.issueLotto();

            outPutView.printBoughtLotto(issuedLotto);

            String winningNumberInput = inputView.readWinningNumbers();
            splitCommaAndConvertToList(winningNumberInput);

            int bonusNumber = Integer.parseInt(inputView.readBonusNumber());
            LottoValidator.validateWinningAndBonusNumbers(winningNumbers, bonusNumber);

            LottoMatchNumberService lottoMatchNumberService = new LottoMatchNumberService(winningNumbers, bonusNumber);

            Map<WinningRank, Integer> winningRankIntegerMap = lottoMatchNumberService.calculateResults(issuedLotto);
            outPutView.printWinningStatistic(winningRankIntegerMap);

            double profitRate = CalculateProfitRateService.calculateProfitRate(winningRankIntegerMap,
                    Integer.parseInt(buyingPrice));
            outPutView.printProfitRate(profitRate);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void splitCommaAndConvertToList(String winningNumber) throws IllegalArgumentException {
        StringTokenizer stringTokenizer = new StringTokenizer(winningNumber, ",");
        winningNumbers.clear();

        while (stringTokenizer.hasMoreTokens()) {
            int number = Integer.parseInt(stringTokenizer.nextToken().trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
            winningNumbers.add(number);
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }
}
