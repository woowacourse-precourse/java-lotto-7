package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Constants;

import java.util.*;

public class BoughtLottos implements Iterable<Lotto> {
    
    private final long LOTTO_PRICE = 1000;
    
    private final List<Lotto> lottos;
    
    private BoughtLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    
    public static BoughtLottos getInstance(SpendingMoney money) {
        long lottoTicketCount = money.get() / 1000L;
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < lottoTicketCount; i++) {
            List<Integer> lottoNumbers =
                    Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER,
                            Constants.MAX_LOTTO_NUMBER, Constants.CONSIST_NUMBER_OF_LOTTO);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return new BoughtLottos(lottos);
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto)
                    .append("\n");
        }
        return stringBuilder.toString();
    }
    
    @Override
    public Iterator<Lotto> iterator() {
        return new BoughtLottosIterator();
    }
    
    public long getSpendMoney() {
        return lottos.size() * LOTTO_PRICE;
    }
    
    public long getSize() {
        return lottos.size();
    }
    
    private class BoughtLottosIterator implements Iterator<Lotto> {
        
        private int index;
        
        private BoughtLottosIterator() {
            this.index = 0;
        }
        
        @Override
        public boolean hasNext() {
            return index < lottos.size();
        }
        
        @Override
        public Lotto next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Lotto lotto = lottos.get(index);
            index++;
            return lotto;
        }
    }
}
