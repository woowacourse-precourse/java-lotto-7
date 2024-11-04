package lotto.service.domain.numbergenerator;

import java.util.List;

public interface RandomNumberGenerator {
    List<Integer> makeLottoRandomNumber();
    int makeLottoBonusNumber();
}
