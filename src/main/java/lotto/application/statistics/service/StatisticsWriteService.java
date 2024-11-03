package lotto.application.statistics.service;

import lotto.application.prize.service.PrizeResponse;
import lotto.application.statistics.domain.Statistics;
import lotto.application.statistics.domain.StatisticsResult;
import lotto.application.ticket.dto.TicketResponse;
import lotto.usecase.StatisticsResponse;

public class StatisticsWriteService {

    public StatisticsResponse compile(TicketResponse ticket, PrizeResponse prize) {
        Statistics statistics = Statistics.of(ticket.lottos(), prize.getPrizeNumberResult());
        StatisticsResult result = statistics.compile();
        return StatisticsResponse.from(result);
    }

}
