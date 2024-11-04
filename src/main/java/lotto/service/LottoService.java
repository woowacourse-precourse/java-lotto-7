package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.AppConstants;
import lotto.dto.LottoRequest;
import lotto.dto.LottoResultResponse;
import lotto.dto.LottoTicketDto;
import lotto.model.LottoTicket;
import lotto.model.LottoResult;
import lotto.model.LottoRanking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    public List<LottoTicketDto> generateLottoTickets(int purchaseAmount) {
        int purchaseCount = purchaseAmount / AppConstants.LOTTO_TICKET_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(AppConstants.LOTTO_MIN_NUMBER, AppConstants.LOTTO_MAX_NUMBER, AppConstants.LOTTO_NUMBER_COUNT);
            tickets.add(new LottoTicket(numbers));
        }

        return tickets.stream()
                .map(ticket -> new LottoTicketDto(new ArrayList<>(ticket.getNumbers())))
                .collect(Collectors.toList());
    }

    public LottoResultResponse getLottoResult(LottoRequest request) {
        LottoResult lottoResult = new LottoResult();

        List<LottoTicket> tickets = request.purchaseTickets().stream()
                .map(dto -> new LottoTicket(dto.numbers()))
                .toList();

        for (LottoTicket ticket : tickets) {
            int matchCount = ticket.getMatchCount(request.winningNumbers());
            boolean bonusMatch = ticket.contains(request.bonusNumber());
            LottoRanking ranking = LottoRanking.getRanking(matchCount, bonusMatch);
            lottoResult.addRanking(ranking);
        }
        double profitRate = Math.round((double) lottoResult.getTotalPrize() / request.purchaseAmount() * 100 * 100) / 100.0;
        return new LottoResultResponse(lottoResult.getRankingCount(), profitRate);
    }
}