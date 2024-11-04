package lotto.service;

import lotto.domain.WinningNumbers;
import lotto.dto.WinningNumbersDto;
import lotto.repository.WinningNumbersRepository;

public class WinningNumberService {
    private final WinningNumbersRepository winningNumbersRepository = WinningNumbersRepository.getInstance();

    public void save(final WinningNumbersDto dto) {
        winningNumbersRepository.save(WinningNumbers.fromDto(dto));
    }
}
