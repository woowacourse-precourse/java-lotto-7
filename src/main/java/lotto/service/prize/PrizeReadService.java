package lotto.service.prize;

import lotto.domain.prize.Prize;
import lotto.repository.prize.PrizeReadRepository;

public class PrizeReadService {
    private final PrizeReadRepository repository;

    public PrizeReadService(PrizeReadRepository repository) {
        this.repository = repository;
    }

    public PrizeResponse getPrize(Long id) {
        Prize prize = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재 하지 않는 당첨 ID 입니다."));

        return PrizeResponse.from(prize.getPrizeNumber());
    }

}
