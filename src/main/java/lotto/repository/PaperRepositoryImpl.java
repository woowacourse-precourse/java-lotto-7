package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class PaperRepositoryImpl implements PaperRepository{
    private final List<Lotto> lottoPaper;

    public PaperRepositoryImpl() {
        this.lottoPaper = new ArrayList<Lotto>();
    }

    @Override
    public void savePaper(Lotto lotto) {
        lottoPaper.add(lotto);
    }

    @Override
    public List<Lotto> getAllPaper() {
        return lottoPaper;
    }
}
