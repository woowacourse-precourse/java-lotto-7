package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.dto.LottoPurchase;
import lotto.dto.WinningStatistics;
import lotto.model.LottoAnswer;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void startLottoProgram(){
        LottoPurchase lottoPurchase = inputView.getLottoTicketPurchase();

        List<Lotto> lottoTickets = buyTickets(lottoPurchase);
        printPurchaseTicket(lottoTickets);

        LottoAnswer lottoAnswer = getLottoAnswer();
        List<LottoResult> results = compareWithAnswer(lottoAnswer, lottoTickets);

        WinningStatistics winningStatistics = new WinningStatistics(results, lottoPurchase.getAmount());
        outputView.printWinningStatistics(winningStatistics);
    }
    private LottoAnswer getLottoAnswer(){
        List<Integer> lottoWinningNumbers = inputView.getLottoAnswer();
        Integer bonusNumber = inputView.getBonusNumber(lottoWinningNumbers);
        return new LottoAnswer(lottoWinningNumbers, bonusNumber);
    }

    private List<LottoResult> compareWithAnswer(LottoAnswer lottoAnswer, List<Lotto> lottoTickets){
        return lottoTickets.stream()
                .map(lottoAnswer::getLottoAgreement)
                .map(matchingAgreement -> LottoResult.valueOf(matchingAgreement[0], matchingAgreement[1]))
                .toList();
    }

    private void printPurchaseTicket(List<Lotto> lottoTickets){
        List<List<Integer>> tickets = lottoTickets.stream()
                .map(Lotto::getLottoNumbers)
                .toList();

        outputView.printLottoTicketList(tickets);
    }

    private List<Lotto> buyTickets(LottoPurchase lottoPurchase){
        return IntStream.range(0,lottoPurchase.getTicketNumber())
                .mapToObj(i->lottoGenerator.generateTicket())
                .toList();
    }
}
