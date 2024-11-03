package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    // 메인 실행 메서드 - 로또 구매부터 결과 출력까지의 흐름을 제어
    public void run() {
        while (true) {
            try {
                int purchaseAmount = inputPurchaseAmount(); // 구매 금액 입력
                LottoTicket lottoTicket = handleLottoPurchase(purchaseAmount);  // 로또 구매 처리 후 티켓 반환
                WinningNumbers winningNumbers = inputWinningNumbers(); // 당첨 번호 입력
                LottoResult result = calculateAndDisplayResults(lottoTicket.getLottoList(), winningNumbers); // 결과 계산 및 출력
                displayTotalProfitRate(purchaseAmount, result); // 총 수익률 출력
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                outputView.displayError("[ERROR] " + e.getMessage()); // 에러 메시지 출력
            }
        }
    }

    // 로또 구매 금액을 입력 받는 메서드 - 유효하지 않은 입력 시 다시 시도
    private int inputPurchaseAmount() {
        while (true) {
            try {
                return inputView.readPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.displayError("[ERROR] " + e.getMessage());
            }
        }
    }

    // 로또를 구매하고 티켓을 생성하여 반환하는 메서드
    private LottoTicket handleLottoPurchase(int purchaseAmount) {
        List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount); // 금액에 따라 로또 구매
        LottoTicket lottoTicket = new LottoTicket(new ArrayList<>()); // 빈 리스트로 LottoTicket 생성

        for (Lotto lotto : purchasedLottos) {
            lottoTicket.addLotto(lotto); // 구매한 로또를 LottoTicket에 추가
        }

        outputView.printLottoNumbers(purchasedLottos.size(), purchasedLottos); // 구매한 로또 수량 및 번호 출력
        return lottoTicket;
    }

    // 당첨 번호를 입력 받는 메서드 - 유효하지 않은 입력 시 다시 시도
    private WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                return inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    // 구매한 로또와 당첨 번호를 바탕으로 결과를 계산하고 출력하는 메서드
    private LottoResult calculateAndDisplayResults(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        LottoResult result = lottoService.calculateResult(purchasedLottos, winningNumbers); // 로또 결과 계산
        outputView.printLottoResults(result); // 계산된 결과 출력
        return result;
    }

    // 총 수익률을 계산하고 출력하는 메서드
    private void displayTotalProfitRate(int purchaseAmount, LottoResult result) {
        double totalProfitRate = lottoService.calculateProfitRate(purchaseAmount, result.calculateTotalPrize()); // 수익률 계산
        outputView.printTotalProfitRate(totalProfitRate); // 수익률 출력
    }
}
