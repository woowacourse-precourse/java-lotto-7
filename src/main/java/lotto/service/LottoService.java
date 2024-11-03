package lotto.service;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;

import java.math.BigInteger;
import java.util.List;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoSeller;
import lotto.domain.Winning;
import lotto.domain.WinningLotto;
import lotto.domain.WinningReport;

public class LottoService {
    private final LottoRetailer lottoRetailer;

    public LottoService() {
        this.lottoRetailer = createLottoRetailer();
    }

    private LottoRetailer createLottoRetailer() {
        return new LottoRetailer(createLottoSeller());
    }

    private LottoSeller createLottoSeller() {
        return new LottoSeller(LOTTO_PRICE, createLottoMachine());
    }

    private LottoMachine createLottoMachine() {
        return new LottoMachine(createLottoNumberGenerator());
    }

    private LottoNumberGenerator createLottoNumberGenerator() {
        return new LottoNumberGenerator(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_OF_LOTTO_NUMBERS);
    }

    public LottoBuyer createLottoBuyer(BigInteger amount) {
        return lottoRetailer.sellAsMuchAs(amount);
    }

    public WinningLotto createWinningLotto(List<Integer> numbers) {
        return lottoRetailer.createWinningLotto(numbers);
    }

    public WinningReport createWinningReport(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        List<Winning> winnings = lottoBuyer.checkWinningsBy(winningLotto);
        return new WinningReport(winnings);
    }
}
