package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.dto.LottoDto;
import lotto.repository.LottoRepository;
import lotto.utils.LottoGenerator;

public class LottoService {
    private final LottoRepository lottoRepository;
    private LottoAnswer lottoAnswer;
    private BonusNumber bonusNumber;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public int getLottoCount(int money) {
        validateMoney(money);
        return money / LottoConstant.LOTTO_PRICE;
    }

    private void validateMoney(int money) {
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 입력해주세요.");
        }
    }

    public void issueLottos(int count) {
        List<Lotto> lottos = LottoGenerator.getLottos(count);
        lottos.forEach(lottoRepository::save);
    }

    public List<LottoDto> getLottoList() {
        return lottoRepository.findAll().stream()
                .map(lotto -> new LottoDto(lotto.getLottoNumbers()))
                .collect(Collectors.toList());
    }

    public void saveLottoAnswer(List<Integer> lottoAnswer) {
        this.lottoAnswer = new LottoAnswer(lottoAnswer);
    }

    public void saveBonusNumber(Integer bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

}
