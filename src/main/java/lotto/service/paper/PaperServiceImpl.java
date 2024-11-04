package lotto.service.paper;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.dto.PaperDto;
import lotto.exception.paper.PurchaseAmountNotNatureException;
import lotto.exception.paper.PurchaseAmountUnitException;
import lotto.repository.paper.PaperRepository;

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

    @Override
    public List<PaperDto> getAllPaper() {
        return paperRepository.getAllPaper()
                .stream()
                .map(lotto -> new PaperDto(lotto.getLotto()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> paper = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(paper);
        return paper;
    }
}
