package lotto.io;

import lotto.vendingmachine.Lotto;

import java.util.List;

public class OutputWriter {

    public void write(List<Lotto> lottes) {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotte : lottes) {
            sb.append(lotte.toString()).append("\n");
        }

        System.out.println(sb);
    }
}
