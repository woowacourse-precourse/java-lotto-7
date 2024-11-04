package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.exception.paper.PurchaseAmountNotNatureException;
import lotto.exception.paper.PurchaseAmountUnitException;
import lotto.repository.PaperRepository;

public class PaperServiceImpl implements PaperService{
    private final PaperRepository paperRepository;
    private static final int LOTTO_PRICE = 1000;
    public PaperServiceImpl(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    @Override
    public void savePaper(int amount) {
        if (amount <= 0) {
            throw new PurchaseAmountNotNatureException();
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new PurchaseAmountUnitException();
        }

        int ticketCount = amount / LOTTO_PRICE;

        for (int i = 0; i < ticketCount; i++) {
            Lotto paper = new Lotto(generateLottoNumbers());
            paperRepository.savePaper(paper);
        }
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> paper = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(paper);
        return paper;
    }
}
