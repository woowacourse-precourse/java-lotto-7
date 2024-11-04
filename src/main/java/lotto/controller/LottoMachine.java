package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.dto.WinningRankCountDto;
import lotto.service.LottoRankCounter;
import lotto.service.LottoService;
import lotto.service.PurchaseService;
import lotto.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.Constants.*;
import static lotto.view.OutputView.printErrorMessage;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseService purchaseService;
    private final LottoService lottoService;
    private final WinningNumbersService winningNumbersService;
    private final LottoRankCounter lottoRankCounter;

    public LottoMachine(InputView inputView, OutputView outputView,
                        PurchaseService purchaseService, LottoService lottoService,
                        WinningNumbersService winningNumbersService,
                        LottoRankCounter lottoRankCounter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseService = purchaseService;
        this.lottoService = lottoService;
        this.winningNumbersService = winningNumbersService;
        this.lottoRankCounter = lottoRankCounter;
    }

    public void run () {
        Integer lottoTicketCount = lottoPurchase();

        Lottos lottos = generateLottos(lottoTicketCount);

        WinningNumbers winningNumbers = getWinningNumbersAndBonusNumber();

        WinningRankCountDto winningRankCountDto = getWinningRanks(lottos, winningNumbers);

        getProfitRate(winningRankCountDto, lottoTicketCount);
    }

    public Lottos generateLottos (Integer lottoTicketCount) {
        Lottos lottos = createLottos(lottoTicketCount);

        outputView.printLottos(lottos);

        return lottos;
    }

    private Lottos createLottos (Integer lottoTicketCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i ++ ) {
            List<Integer> randomNumbers = generateRandomNumbers();
            Lotto lotto = lottoService.generateLotto(randomNumbers);
            lottos.add(lotto);
        }

        return lottoService.generateLottos(lottos);
    }


    private Integer lottoPurchase () {
        Integer ticketCount = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                String rawPurchaseAmount = inputView.getPurchaseAmount();
                ticketCount = purchaseService.purchaseLotto(rawPurchaseAmount);

                validInput = true;

            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }

        return ticketCount;
    }

    private List<Integer> generateRandomNumbers () {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

    private WinningNumbers getWinningNumbersAndBonusNumber () {
        WinningNumbers winningNumbers = getWinningNumbers();

        getBonusNumber(winningNumbers);

        return winningNumbers;
    }

    private WinningNumbers getWinningNumbers () {
        WinningNumbers winningNumbers = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                String inputWinningNumbers = inputView.getWinningNumbers();

                winningNumbers = winningNumbersService.getWinningNumbers(inputWinningNumbers);

                validInput = true;

            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }

        return winningNumbers;
    }

    private void getBonusNumber (WinningNumbers winningNumbers) {

        boolean validInput = false;

        while (!validInput) {
            try {
                String rawBonusNumber = inputView.getBonusNumber();
                winningNumbersService.getBonusNumber(winningNumbers, rawBonusNumber);

                validInput = true;

            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningRankCountDto getWinningRanks (Lottos lottos, WinningNumbers winningNumbers) {
        List<LottoRank> WinningRanks = winningNumbersService.getWinningRanks(lottos, winningNumbers);

        WinningRankCountDto winningRankCountDto = lottoRankCounter.countWinningRanks(WinningRanks);
        outputView.printWinningDetails(winningRankCountDto);

        return winningRankCountDto;
    }

    private void getProfitRate (WinningRankCountDto winningRankCountDto, Integer lottoTicketCount) {
        String profitRate = lottoRankCounter.getProfitRate(winningRankCountDto, lottoTicketCount);

        outputView.printProfitRate(profitRate);
    }
}
