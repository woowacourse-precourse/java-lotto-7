package lotto.service.paper;

import java.util.List;
import lotto.Lotto;
import lotto.dto.PaperDto;

public interface PaperService {
    void savePaper(int amount);
    List<PaperDto> getAllPaper();
}
