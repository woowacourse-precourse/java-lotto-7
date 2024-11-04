package lotto.service.winning;

import java.util.List;
import lotto.dto.PaperDto;
import lotto.dto.ResultDto;

public interface WinningService {
    void saveWinning(List<Integer> numbers);

    void saveBonusNumber(int bonusNumber);

    ResultDto getResult(List<PaperDto> papers);
}
