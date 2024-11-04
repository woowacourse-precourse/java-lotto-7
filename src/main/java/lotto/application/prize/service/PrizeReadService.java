package lotto.application.prize.service;

import static lotto.application.prize.message.Message.UNVALID_PRIZE_ID;

import lotto.application.prize.domain.Prize;
import lotto.application.prize.repository.PrizeReadRepository;

public class PrizeReadService {
    private final PrizeReadRepository repository;

    public PrizeReadService(PrizeReadRepository repository) {
        this.repository = repository;
    }

    public PrizeResponse getPrize(Long id) {
        Prize prize = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(UNVALID_PRIZE_ID));

        return PrizeResponse.from(prize.getPrizeNumber());
    }

}
