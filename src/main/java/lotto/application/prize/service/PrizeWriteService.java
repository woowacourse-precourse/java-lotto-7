package lotto.application.prize.service;

import java.util.List;
import lotto.application.common.IdGenerator;
import lotto.application.prize.domain.Prize;
import lotto.application.prize.domain.PrizeNumber;
import lotto.application.prize.repository.PrizeWriteRepository;
import lotto.application.ticket.domain.ticket.Lotto;

public class PrizeWriteService {

    private final CreatePrizeNumberService createPrizeNumberService;
    private final PrizeWriteRepository repository;
    private final IdGenerator idGenerator;

    public PrizeWriteService(
            CreatePrizeNumberService createPrizeNumberService,
            PrizeWriteRepository repository,
            IdGenerator idGenerator) {

        this.createPrizeNumberService = createPrizeNumberService;
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Long create(List<Integer> winNums, int bonusNum) {
        Lotto winLotto = Lotto.of(winNums);
        PrizeNumber prizeNumber = createPrizeNumberService.execute(winLotto, bonusNum);
        Prize prize = Prize.of(idGenerator.generate(), prizeNumber);

        return repository.save(prize);
    }

}
