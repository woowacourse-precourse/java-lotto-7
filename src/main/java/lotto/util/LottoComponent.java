package lotto.util;

import lotto.model.LottoGenerator;
import lotto.model.RankCalculator;
import lotto.model.WinningNumberGenerator;
import lotto.service.TicketService;

public record LottoComponent(TicketService ticketService,
                             LottoGenerator lottoGenerator,
                             RankCalculator rankCalculator,
                             WinningNumberGenerator winningNumberGenerator) {}
