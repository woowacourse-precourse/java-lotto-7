package lotto.service.prize;

import java.util.List;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeNumber;
import lotto.domain.ticket.Lotto;
import lotto.repository.prize.PrizeWriteRepository;
import lotto.service.IdGenerator;

public class PrizeWriteService {

    private final CreatePrizeNumberService createPrizeNumberService;
    private final PrizeWriteRepository prizeWriteRepository;
    private final IdGenerator idGenerator;

    public PrizeWriteService(CreatePrizeNumberService createPrizeNumberService,
                             PrizeWriteRepository prizeWriteRepository,
                             IdGenerator idGenerator) {
        this.createPrizeNumberService = createPrizeNumberService;
        this.prizeWriteRepository = prizeWriteRepository;
        this.idGenerator = idGenerator;
    }

    public Long create(int bonusNum, List<Integer> winNums) {
        Lotto winLotto = Lotto.of(winNums);
        PrizeNumber prizeNumber = createPrizeNumberService.execute(bonusNum, winLotto);

        Prize createdPrize = Prize.of(idGenerator.generate(), prizeNumber);
        Long savedId = prizeWriteRepository.save(createdPrize);

        return savedId;
    }
}
