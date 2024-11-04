package lotto.controller;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.EarningRate;
import lotto.model.Lotto;
import lotto.model.Amount;
import lotto.model.LottoMatchEvaluator;
import lotto.model.LottoPublisher;
import lotto.view.InputView;
import lotto.view.OutputView;
import utils.TypeConverter;
import utils.ValidationManager;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void playLotto() {
        //금액 입려처리,금액에 따른 로또 생성 및 출력
        Amount validAmount = handleAmountInputError();
        LottoPublisher lottoPublisher = new LottoPublisher(validAmount.getPublishCount());
        outputView.printPublishedLotto(lottoPublisher.getPublishedLotto());

        //당첨 번호 보너스 번호 입력 처리
        List<Integer> validLottoNumbers = handleLottoNumberInputError();
        int validBonusNumber = handleBonusInputError();

        //로또 당첨 결과 연산 및 출력
        LottoMatchEvaluator lottoMatchEvaluator = new LottoMatchEvaluator(validLottoNumbers, validBonusNumber, lottoPublisher);
        List<Integer> lottoWinningCounts = lottoMatchEvaluator.getLottoWinningCounts();
        outputView.printOrderdLottoResult(lottoWinningCounts);

        //수익률 계산 및 출력
        EarningRate earningRate = new EarningRate(lottoWinningCounts, validAmount);
        outputView.printEarningRate(earningRate.getEarningRate());
    }

    public Amount handleAmountInputError() {
        boolean valid = false;

        while (!valid) {
            try {
                String input = inputView.readInput(Amount.getRequestMessage());
                Amount amount = new Amount(input); //객체 생성하며 검증
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public List<Integer> handleLottoNumberInputError() {
        boolean valid = false;

        while (!valid) {
            try {
                String lottoInput = inputView.readInput(Lotto.getRequestMessage());
                ValidationManager.isNumbersDividedByComma(lottoInput); //정수와 쉼표로 이루어져있는지 확인
                Lotto lotto = new Lotto(TypeConverter.ToNumberList(lottoInput));//6자 이상인지 범위는 (1-45)인지 확인후 객체 생성
                return lotto.getLottoNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public int handleBonusInputError() {
        boolean valid = false;

        while (!valid) {
            try {
                String input = inputView.readInput(Bonus.getRequestMessage());
                Bonus bonus = new Bonus(input);
                return bonus.getBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}
