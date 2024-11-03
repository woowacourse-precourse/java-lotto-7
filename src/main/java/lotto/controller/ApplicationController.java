package lotto.controller;

import static lotto.service.Validator.isLottoNumbersDuplicated;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.Extractor;
import lotto.service.LottoService;
import lotto.service.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationController {
    private final Extractor extractor;
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationController(Extractor extractor, LottoService lottoService, InputView inputView, OutputView outputView) {
        this.extractor = extractor;
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 0. Lottos 클래스를 생성
        Lottos lottos = Lottos.getInstance();

        // 1. 구매 금액을 입력 받음.
        int inputPrice = inputPrice();
        outputView.printPurchaseLottoCount(inputPrice / 1000);

        // 2. 해당 금액을 바탕으로 로또를 구매함.
        buyLottos(inputPrice, lottos);

        // 3. 당첨 번호를 입력 받는다.
        Lotto inputLottoNumbers = inputLottoNumbers();
        lottos.setInputLottoNumbers(inputLottoNumbers);

        // 4. 보너스 번호를 입력 받는다.
        int bonusNumber = inputBonusNumber(inputLottoNumbers);
        lottos.setBonusNumber(bonusNumber);

        // 5. 결과 출력
        printResult(lottos, inputPrice);
    }

    private void printResult(Lottos lottos, int price) {
        // 당첨 통계 출력
        lottoService.setWinningLottoCount(lottos);
        outputView.printWinningLotto(lottos);

        // 수익률 출력
        double rateOfReturn = lottoService.getRateOfReturn(lottos, price);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private int inputBonusNumber(Lotto lottoNumbers) {
        while (true) {
            try {
                String inputBonusNumber = Validator.isEmpty(inputView.inputBonusNumber());
                return Validator.validateBonusNumber(lottoNumbers.getNumbers(), inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void buyLottos(int inputPrice, Lottos lottos) {
        lottoService.addLotto(lottos, inputPrice);
        outputView.printPurchaseLottos(lottos);
    }

    private Lotto inputLottoNumbers() {
        while(true) {
            try {
                String inputLottoNumbers = Validator.isEmpty(inputView.inputLottoNumbers());
                List<Integer> numbers = extractor.extractLottoNumber(inputLottoNumbers);
                isLottoNumbersDuplicated(numbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputPrice() {
        while (true) {
            try {
                String inputPrice = Validator.isEmpty(inputView.inputPrice().strip());
                return Validator.isLottoPriceValid(inputPrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
