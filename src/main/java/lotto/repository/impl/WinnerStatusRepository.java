package lotto.repository.impl;

import java.util.Optional;
import lotto.domain.WinnerStatus;
import lotto.repository.SingleRepository;

public class WinnerStatusRepository implements SingleRepository<WinnerStatus> {

    private WinnerStatus winnerStatus;

    @Override
    public WinnerStatus save(WinnerStatus winnerStatus) {
        this.winnerStatus = winnerStatus;
        return this.winnerStatus;
    }

    @Override
    public Optional<WinnerStatus> get() {
        return Optional.ofNullable(winnerStatus);
    }
}
