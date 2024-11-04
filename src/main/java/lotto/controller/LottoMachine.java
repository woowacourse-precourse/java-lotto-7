package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.dto.WinningRankCountDto;
import lotto.service.LottoService;
import lotto.service.PurchaseService;
import lotto.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.Constants.*;
import static lotto.service.LottoRankCounter.countWinningRanks;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseService purchaseService;
    private final LottoService lottoService;
    private final WinningNumbersService winningNumbersService;

    public LottoMachine(InputView inputView, OutputView outputView,
                        PurchaseService purchaseService, LottoService lottoService,
                        WinningNumbersService winningNumbersService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseService = purchaseService;
        this.lottoService = lottoService;
        this.winningNumbersService = winningNumbersService;
    }

    public void run () {
        Integer lottoTicketCount = lottoPurchase();

        Lottos lottos = generateLottos(lottoTicketCount);

        WinningNumbers winningNumbers = getWinningNumbers();

        WinningRankCountDto winningRankCountDto = getWinningRanks(lottos, winningNumbers);
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
        String rawPurchaseAmount = inputView.getPurchaseAmount();

        return purchaseService.purchaseLotto(rawPurchaseAmount);
    }

    private List<Integer> generateRandomNumbers () {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

    private WinningNumbers getWinningNumbers () {
        String inputWinningNumbers = inputView.getWinningNumbers();

        WinningNumbers winningNumbers = winningNumbersService.getWinningNumbers(inputWinningNumbers);

        String rawBonusNumber = inputView.getBonusNumber();

        winningNumbersService.getBonusNumber(winningNumbers, rawBonusNumber);

        return winningNumbers;
    }

    private WinningRankCountDto getWinningRanks (Lottos lottos, WinningNumbers winningNumbers) {
        List<LottoRank> WinningRanks = winningNumbersService.getWinningRanks(lottos, winningNumbers);

        WinningRankCountDto winningRankCountDto = countWinningRanks(WinningRanks);
        outputView.printWinningDetails(winningRankCountDto);

        return winningRankCountDto;
    }
}
