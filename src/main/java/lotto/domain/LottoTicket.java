package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

   public void showLottoTicket(){
       System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
       for (Lotto lotto : lottos) {
           System.out.println(lotto);
       }
   }

}
