package lotto.view;

import java.util.List;

public class Response {
    public void outputLottos(List<List<String>> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for(List<String> lotto : lottos) {
            System.out.println("[" + String.join(", ", lotto) + "]");
        }
    }
}
