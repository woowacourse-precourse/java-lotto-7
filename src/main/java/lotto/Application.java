package lotto;

import static lotto.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.LottoConstants.MIN_LOTTO_NUMBER;

import java.math.BigInteger;
import java.util.List;

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
