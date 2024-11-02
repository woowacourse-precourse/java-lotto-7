package lotto;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;

import java.math.BigInteger;
import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoSeller;
import lotto.domain.LottoTicket;
import lotto.service.LottoRetailer;
import lotto.view.InputValidator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        LottoController lottoController = new LottoController(inputView, inputValidator);
        LottoNumberGenerator lottoNumberGenerator
                = new LottoNumberGenerator(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_OF_LOTTO_NUMBERS);
        LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);
        LottoSeller lottoSeller = new LottoSeller(LOTTO_PRICE, lottoMachine);
        LottoRetailer lottoRetailer = new LottoRetailer(lottoSeller);

        BigInteger purchaseAmount = new BigInteger(inputView.requestPurchaseAmount());
        LottoBuyer lottoBuyer = lottoRetailer.sellAsMuchAs(purchaseAmount);

        List<Integer> winningLottoNumbers = lottoController.deliverNumbers();
        LottoTicket winningLotto = lottoRetailer.createWinningLotto(winningLottoNumbers);
    }
}
