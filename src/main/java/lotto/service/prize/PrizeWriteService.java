package lotto.service.prize;

import java.util.List;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeNumber;
import lotto.domain.ticket.Lotto;
import lotto.repository.prize.PrizeWriteRepository;
import lotto.service.IdGenerator;

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
