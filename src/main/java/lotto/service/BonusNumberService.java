package lotto.service;

import lotto.domain.BonusNumber;
import lotto.dto.BonusNumberDto;
import lotto.repository.BonusNumberRepository;

public class BonusNumberService {
    private final BonusNumberRepository bonusNumberRepository = BonusNumberRepository.getInstance();

    public void saveBonusNumber(final BonusNumberDto dto) {
        bonusNumberRepository.save(dto.fromEntity());
    }

    public BonusNumberDto findBonusNumber() {
        BonusNumber bonusNumber = bonusNumberRepository.find();
        return bonusNumber.toDto();
    }
}
