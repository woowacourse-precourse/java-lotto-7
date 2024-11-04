package lotto.application.statistics.controller;

import lotto.application.prize.dto.PrizeResponse;
import lotto.application.statistics.dto.StatisticsResponse;
import lotto.application.statistics.service.StatisticsWriteService;
import lotto.application.ticket.dto.TicketResponse;

public class StatisticsController {
    private final StatisticsWriteService writeService;

    public StatisticsController(StatisticsWriteService writeService) {
        this.writeService = writeService;
    }

    public StatisticsResponse compile(TicketResponse ticket, PrizeResponse prize) {
        return writeService.compile(ticket, prize);
    }

}
