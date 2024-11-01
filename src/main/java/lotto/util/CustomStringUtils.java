package lotto.util;

import lotto.domain.Lottoes;

public abstract class CustomStringUtils {

    public static void printStringLineFeed(String str) {
        System.out.print(str.concat("\n"));
    }

    public static void printLottoesStatus(Lottoes lottoes) {
        StringBuilder sb = new StringBuilder();

        sb.append(lottoes.getLottoes().size()).append("개를 구매했습니다.\n");

        lottoes.getLottoes().forEach(lotto -> {
            sb.append(lotto.toString()).append("\n");
        });

        System.out.print(sb);
    }
}
