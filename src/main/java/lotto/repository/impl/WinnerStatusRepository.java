package lotto.repository.impl;

import java.util.Optional;
import lotto.domain.WinnerStatus;
import lotto.repository.SingleRepository;

public class WinnerStatusRepository implements SingleRepository<WinnerStatus> {

    private WinnerStatus winnerStatus;

    @Override
    public void save(WinnerStatus object) {
        this.winnerStatus = object;
    }

    @Override
    public Optional<WinnerStatus> get() {
        return Optional.ofNullable(winnerStatus);
    }
}
