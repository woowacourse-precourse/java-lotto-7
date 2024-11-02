package lotto.io;

import lotto.vendingmachine.Lotto;

import java.util.List;

public class OutputWriter {

    public void write(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append(lottos.size()).append("개를 구매했습니다.").append("\n");
        for (Lotto lotte : lottos) {
            sb.append(lotte.toString()).append("\n");
        }

        System.out.println(sb);
    }

    public void printStatistics() {

    }
}
