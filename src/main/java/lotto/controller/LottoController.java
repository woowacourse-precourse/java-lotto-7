package lotto.controller;

import static lotto.view.ViewMessageContainer.OVER_INTEGER_RANGE_ERROR;
import static lotto.view.ViewMessageContainer.SECOND_WINNING_DETAILS_TEMPLATE;
import static lotto.view.ViewMessageContainer.WINNING_DETAILS_TEMPLATE;
import static lotto.view.ViewConstants.VIEW_DELIMITER;

import java.math.BigDecimal;
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
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoReceipt readPurchaseAmount(String input) {
        return lottoService.createLottoReceipt(toBigInteger(input));
    }

    private BigInteger toBigInteger(String input) {
        return new BigInteger(input);
    }

    public WinningLotto getWinningLotto(LottoTicket winningTicket, int bonusNumber) {
        return lottoService.createWinningLotto(winningTicket, bonusNumber);
    }

    public LottoTicket readWinningNumbers(String inputNumbers) {
        return lottoService.createWinningTicket(extractNumbers(inputNumbers));
    }

    private List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split(VIEW_DELIMITER))
                .filter(s -> !s.isBlank())
                .map(this::toInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OVER_INTEGER_RANGE_ERROR);
        }
    }

    public List<String> sendLottoDetails(LottoReceipt lottoReceipt) {
        BigInteger lottoQuantity = lottoService.getLottoQuantity(lottoReceipt);
        String lottoDetails = lottoService.getLottoDetails(lottoReceipt);
        return List.of(lottoQuantity.toString(), lottoDetails);
    }

    public List<String> sendWinningResult(LottoReceipt lottoReceipt, WinningLotto winningLotto) {
        Map<Winning, Integer> winningCounts = lottoService.getWinningCounts(lottoReceipt, winningLotto);
        String winningDetails = conertToWinningDetails(winningCounts);
        BigDecimal rateOfReturn = lottoService.getRateOfReturn(winningCounts, lottoReceipt);
        return List.of(winningDetails, rateOfReturn.toString());
    }

    private String conertToWinningDetails(Map<Winning, Integer> winningCounts) {
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