package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.dto.request.EarningRateRequest;
import lotto.dto.request.LottoAmountRequest;
import lotto.dto.request.LottoResultRequest;
import lotto.dto.response.EarningRateResponse;
import lotto.dto.response.LottoResultResponse;
import lotto.dto.response.LottoesResponse;
import lotto.util.BonusNumberValidator;
import lotto.util.Container;
import lotto.util.LottoAmountValidator;
import lotto.util.WinningNumberParser;

import java.util.List;
import java.util.Map;

public class InputView {

    private final LottoAmountValidator lottoAmountValidator;
    private final WinningNumberParser winningNumberParser;
    private final BonusNumberValidator bonusNumberValidator;
    private final LottoController lottoController;

    public InputView() {
        this.lottoAmountValidator = Container.getInstance(LottoAmountValidator.class);
        this.winningNumberParser = Container.getInstance(WinningNumberParser.class);
        this.bonusNumberValidator = Container.getInstance(BonusNumberValidator.class);
        this.lottoController = Container.getInstance(LottoController.class);
    }

    public int setLottoPrice() {
        String price = Console.readLine();
        return lottoAmountValidator.validate(price);
    }

    public List<Lotto> setLottoes(int amount) {
        LottoesResponse response = lottoController.makeLottoes(LottoAmountRequest.from(amount));
        return response.lottoes();
    }

    public List<Integer> setWinningNumbers() {
        String numbers = Console.readLine();
        return winningNumberParser.parseWinningNumbers(numbers);
    }

    public int setBonusNumber(List<Integer> winningNumbers) {
        String bonusNumber = Console.readLine();
        return bonusNumberValidator.validate(bonusNumber, winningNumbers);
    }

    public Map<Ranking, Integer> getLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        LottoResultResponse response = lottoController.getLottoResult(LottoResultRequest.of(winningNumbers, bonusNumber));
        return response.lottoResult();
    }

    public double getEarningRate(Map<Ranking, Integer> lottoResult, int amount) {
        EarningRateResponse response = lottoController.getEarningRate(EarningRateRequest.of(lottoResult, amount));
        return response.earningRate();
    }
}