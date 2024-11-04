package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.util.InputParser;
import lotto.util.InputValidator;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private InputView inputView = new InputView();
    private InputValidator inputValidator = new InputValidator();
    private InputParser inputParser = new InputParser();
    private OutputView outputView = new OutputView();
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private LottoRepository lottoRepository = new LottoRepository();

    public void startLotto() {
        int purchasePrice = getPurchasePrice();
        creatLottos(purchasePrice);

        List<Integer> winningNumbers = getWinningNumbers();


    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumberList = new ArrayList<>();
        while (true) {
            try {
                String winningNumbers = inputView.getWinningNumbers();
                inputValidator.validateWinningNumbers(winningNumbers);
                inputParser.parseWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return winningNumberList;
    }

    private void creatLottos(int purchasePrice) {
        int lottoCount = purchasePrice / 1000;
        outputView.printCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = lottoNumberGenerator.generate();
            lottoNumber.sort((x, y) -> x - y);
            outputView.printLottoNumber(lottoNumber);
            lottoRepository.save(new Lotto(lottoNumber));
        }
        outputView.printBlank();
    }

    private int getPurchasePrice() {
        int parsedPurchasePrice = 0;
        while (true) {
            try {
                String purchasePrice = inputView.getPurchasePrice();
                inputValidator.validatePurchasePrice(purchasePrice);
                parsedPurchasePrice = inputParser.parsePurchasePrice(purchasePrice);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return parsedPurchasePrice;
    }
}
