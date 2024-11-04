package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.condition.SpendingMoney;
import lotto.utils.Constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** 구매 금액만큼 무작위 숫자로 생성한 로또 티켓들을 보관한다. */
public class BoughtLottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;
    
    private BoughtLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    
    public static BoughtLottos getOfSpendingMoney(SpendingMoney money) {
        long lottoTicketCount = money.get() / Constants.LOTTO_TICKET_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < lottoTicketCount; i++) {
            List<Integer> lottoNumbers =
                    Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER,
                            Constants.MAX_LOTTO_NUMBER, Constants.COUNT_LOTTO_NUMBERS);
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
        return lottos.size() * Constants.LOTTO_TICKET_PRICE;
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
