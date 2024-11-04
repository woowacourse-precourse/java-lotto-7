package lotto.controller;

import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private static final String COMMA = ",";
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoValidation lottoValidation;
    private final LottoService lottoService;

    public LottoController(OutputView outputView, InputView inputVIew, LottoValidation lottoValidation, LottoService lottoService) {
        this.outputView = outputView;
        this.inputView = inputVIew;
        this.lottoValidation = lottoValidation;
        this.lottoService = lottoService;
    }

    public void run() {
        // 로또 구입 금액 입력
        outputView.askPurchasePrice();
        int purchasePrice = getPurchasePrice();

        //로또 번호 구매
        int lottoCount = getLottoCount(purchasePrice);
        outputView.lottoPurchasedCount(lottoCount);
        String lottos = lottoService.buyLotto(lottoCount);

        //구매한 로또 번호 출력
        printLottoPurchasedDetail(lottos);

        //당첨 번호 입력
        outputView.askWinningNumber();
        getValidWinningNumber();

        //보너스 번호 입력
        outputView.askBonusNumber();
        getValidBonusNumber();

        //당첨 결과 처리
        lottoService.calculateWinningResult();
        List<LottoResultDto> winningResult = lottoService.getWinningResult();
        double returnResult = lottoService.returnResult(purchasePrice);

        //결과 출력
        outputView.printResult(winningResult, returnResult);
    }

    private int getPurchasePrice() {
        while (true) {
            try {
                String input = inputView.purchasePrice();
                lottoValidation.validateBlank(input);
                int purchasePrice = lottoValidation.validateParsing(input);
                lottoValidation.validatePositive(purchasePrice);
                lottoValidation.validateDivisible(purchasePrice);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getLottoCount(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    private void printLottoPurchasedDetail(String lottos) {
        outputView.lottoPurchasedDetail(lottos);
    }

    private void getValidWinningNumber() {
        while (true) {
            try {
                String input = inputView.winningNumber();
                lottoValidation.validateBlank(input);
                List<String> splitNumber = List.of(input.split(COMMA));
                List<Integer> winningNumbers = lottoValidation.validateParsing(splitNumber);
                lottoService.saveWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getValidBonusNumber() {
        while (true) {
            try {
                String input = inputView.bonusNumber();
                lottoValidation.validateBlank(input);
                int bonusNumber = lottoValidation.validateParsing(input);
                lottoService.validateBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
