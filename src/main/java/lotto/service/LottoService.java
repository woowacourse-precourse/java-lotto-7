package lotto.service;

public class LottoService {
    public static int LOTTO_PRICES = 1000;

    public int lottoPurchase(int amount) {
        int numberOfLottoes = amount/LOTTO_PRICES;
        return numberOfLottoes;
    }
}
