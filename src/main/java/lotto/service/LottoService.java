package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoRank;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.utils.LottoGenerator;

public interface LottoService {
    public void saveLottoAnswer(List<Integer> lottoAnswer);

    public int getLottoCount(int money);

    public void issueLottos(int count);

    public List<LottoDto> getLottoList();

    public void saveBonusNumber(Integer bonusNumber);

    public LottoResultDto calculateResults(int purchaseMoney);

    public boolean isBonusNumberDuplicate(Integer bonusNumber);
}
