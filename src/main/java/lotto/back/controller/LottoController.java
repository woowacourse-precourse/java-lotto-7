package lotto.back.controller;

import lotto.back.service.LottoService;
import lotto.back.service.impl.LottoServiceImpl;
import lotto.front.view.InputView;
import lotto.front.view.OutputView;
import lotto.global.dto.request.LottoDrawRequestDTO;
import lotto.global.dto.request.LottoMatchRequestDTO;
import lotto.global.dto.request.LottoPurchaseRequestDTO;
import lotto.global.dto.response.LottoMatchResponseDTO;
import lotto.global.dto.response.LottoPurchaseResponseDTO;

public class LottoController {
    private final LottoService lottoService = new LottoServiceImpl();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        purchaseLotto();
        issueDrawnNumbers();
        matchLotto();
    }

    private void purchaseLotto() {
        while (true) {
            try {
                LottoPurchaseRequestDTO lottoPurchaseRequestDTO = inputView.readLottoPrice();
                LottoPurchaseResponseDTO lottoPurchaseResponseDTO = lottoService.issueLottos(lottoPurchaseRequestDTO);
                outputView.writePurchasedLotto(lottoPurchaseResponseDTO);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    private void issueDrawnNumbers() {
        while (true) {
            try {
                LottoDrawRequestDTO lottoDrawRequestDTO = inputView.readDrawnNumbers();
                lottoService.saveDrawnNumbers(lottoDrawRequestDTO);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    private void matchLotto() {
        while (true) {
            try {
                LottoMatchRequestDTO lottoMatchRequestDTO = inputView.readBonusNumber();
                LottoMatchResponseDTO lottoMatchResponseDTO = lottoService.matchLotto(lottoMatchRequestDTO);
                outputView.writeWinningStats(lottoMatchResponseDTO);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }
}
