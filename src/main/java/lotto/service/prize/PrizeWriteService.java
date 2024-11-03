package lotto.service.prize;

import java.util.List;
import lotto.domain.prize.BonusNumber;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeNumber;
import lotto.domain.prize.WinnerNumbers;
import lotto.domain.ticket.Lotto;
import lotto.repository.prize.PrizeWriteRepository;
import lotto.service.IdGenerator;

public class PrizeWriteService {
    private final PrizeWriteRepository prizeWriteRepository;
    private final IdGenerator idGenerator;

    public PrizeWriteService(PrizeWriteRepository prizeWriteRepository, IdGenerator idGenerator) {
        this.prizeWriteRepository = prizeWriteRepository;
        this.idGenerator = idGenerator;
    }

    public Long create(int bonusNum, List<Integer> winNums) {
        Lotto winLotto = Lotto.of(winNums);

        BonusNumber createdBonusNum = BonusNumber.of(bonusNum, winLotto);
        WinnerNumbers createdWinNums = WinnerNumbers.of(winLotto);
        PrizeNumber createdPrizeNum = PrizeNumber.of(createdWinNums, createdBonusNum);

        Prize createdPrize = Prize.of(idGenerator.generate(), createdPrizeNum);

        Long savedId = prizeWriteRepository.save(createdPrize);

        return savedId;
    }
}
