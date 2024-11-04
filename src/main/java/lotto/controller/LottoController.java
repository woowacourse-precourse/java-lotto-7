package lotto.controller;

import static lotto.MessageContainer.SECOND_WINNING_DETAILS_TEMPLATE;
import static lotto.MessageContainer.WINNING_DETAILS_TEMPLATE;
import static lotto.view.ViewConstants.VIEW_DELIMITER;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoReceipt;
import lotto.domain.LottoTicket;
import lotto.domain.Winning;
import lotto.domain.WinningLotto;
import lotto.domain.WinningReport;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoReceipt readPurchaseAmount(String input) {
        return lottoService.createLottoReceipt(toBigInteger(input));
    }

    public LottoTicket readWinningNumbers(String inputNumbers) {
        return lottoService.createWinningTicket(extractNumbers(inputNumbers));
    }

    public WinningLotto getWinningLotto(LottoTicket winningTicket, int bonusNumber) {
        return lottoService.createWinningLotto(winningTicket, bonusNumber);
    }

    public WinningReport getReport(LottoReceipt lottoReceipt, WinningLotto winningLotto) {
        return lottoService.createWinningReport(lottoReceipt, winningLotto);
    }

    public BigInteger toBigInteger(String input) {
        return new BigInteger(input);
    }

    private List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split(VIEW_DELIMITER))
                .map(this::toInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int toInt(String input) {
        return Integer.parseInt(input);
    }

    public String sendWinningDetails(Map<Winning, Integer> winningCounts) {
        return Winning.valuesAsOrderedStream()
                .map(winning -> {
                    if (winning == Winning.SECOND) {
                        return formatWinningDetails(SECOND_WINNING_DETAILS_TEMPLATE, winning, winningCounts);
                    }
                    return formatWinningDetails(WINNING_DETAILS_TEMPLATE, winning, winningCounts);
                }).collect(Collectors.joining(System.lineSeparator()));
    }

    private String formatWinningDetails(String template, Winning winning, Map<Winning, Integer> winningCounts) {
        return String.format(template,
                winning.getCondition(),
                winning.getPrize(),
                winningCounts.get(winning));
    }
}
