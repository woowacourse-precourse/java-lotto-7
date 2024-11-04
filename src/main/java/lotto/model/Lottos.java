package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final int ticketCount;
    private final List<Lotto> lottos;


    public Lottos(Price price) {
        this.ticketCount = price.convertToTicket();
        this.lottos = createLottos();
    }

    public List<Lotto> createLottos() {
        List<Lotto> lottosNumber = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottosNumber.add(Lotto.createAutoLotto());
        }
        return lottosNumber;
    }

    public String getLottosToString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lottos.size(); i++) {
            result.append(lottos.get(i));
            if (i < lottos.size() - 1) { // 마지막 요소가 아니면 줄바꿈 추가
                result.append("\n");
            }
        }
        return result.toString();
    }

    public List<Lotto> getLottos(){
        return Collections.unmodifiableList(lottos);
    }

    public int getTicketCount(){
        return ticketCount;
    }
}
