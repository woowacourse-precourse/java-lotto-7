package lotto.service;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoReceipt;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoSeller;
import lotto.domain.LottoTicket;
import lotto.domain.Winning;
import lotto.domain.WinningLotto;
import lotto.domain.WinningReport;

public class LottoService {
    private final LottoSeller lottoSeller;

    public LottoService() {
        this.lottoSeller = createLottoSeller();
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

    public LottoReceipt createLottoReceipt(BigInteger amount) {
        return lottoSeller.sellAsMuchAs(amount);
    }

    public LottoTicket createWinningTicket(List<Integer> winningNumbers) {
        return lottoSeller.createLottoTicketFor(winningNumbers);
    }

    public WinningLotto createWinningLotto(LottoTicket winningTicket, int bonusNumber) {
        return lottoSeller.createWinningLotto(winningTicket, bonusNumber);
    }

    private WinningReport createWinningReport(LottoReceipt lottoReceipt, WinningLotto winningLotto) {
        List<Winning> winnings = lottoReceipt.checkWinningsWith(winningLotto);
        return new WinningReport(winnings);
    }

    public Map<Winning, Integer> getWinningCounts(LottoReceipt lottoReceipt, WinningLotto winningLotto) {
        WinningReport winningReport = createWinningReport(lottoReceipt, winningLotto);
        return winningReport.getWinningCounts();
    }

    public BigInteger getLottoQuantity(LottoReceipt lottoReceipt) {
        return lottoReceipt.getIssuedLottoQuantity();
    }

    public String getLottoDetails(LottoReceipt lottoReceipt) {
        return lottoReceipt.toString();
    }

    public BigDecimal getRateOfReturn(Map<Winning, Integer> winningCounts, LottoReceipt lottoReceipt) {
        BigInteger totalPrize = Winning.tellTotalPrize(winningCounts);
        return lottoReceipt.calculateRateOfReturn(totalPrize);
    }
}
