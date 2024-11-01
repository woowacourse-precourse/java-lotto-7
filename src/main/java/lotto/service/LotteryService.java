package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;

public class LotteryService {
    private final LottoRepository lottoRepository;

    public LotteryService(LottoRepository lottoRepository) {
        this.lottoRepository = LottoRepository.getInstance();
    }

    public List<String> buyLotto(Integer purchaseMoney) {
        Integer lottoAmount = getAmountByMoney(purchaseMoney);
        createLottos(lottoAmount);
        return getBuyResult();
    }

    private List<String> getBuyResult() {
        List<String> result = new ArrayList<>();
        result.add(lottoRepository.getLottoCount()+"개를 구매했습니다.");
        lottoRepository.findAll().forEach(lotto -> result.add(lotto.toString()));
        return result;
    }

    private void createLottos(Integer lottoAmount) {
        for (int i = 0; i < lottoAmount; i++) {
            lottoRepository.addLotto(new Lotto(createLottoNums()));
        }
    }

    private List<Integer> createLottoNums() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private Integer getAmountByMoney(Integer purchaseMoney) {
        validatePurchaseMoney(purchaseMoney);
        return purchaseMoney / 1000;
    }

    private void validatePurchaseMoney(Integer purchaseMoney) {
        validateMinimum(purchaseMoney);
        validateChange(purchaseMoney);
    }

    private void validateChange(Integer purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private void validateMinimum(Integer purchaseMoney) {
        if (purchaseMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다.");
        }
    }

}
