package lotto.domain;

import java.util.List;


public  class LottoDomain {

    public static int price;
    public static int playLumber;
    public static List<Integer> lottoNumbers;


    public LottoDomain(int price) {
        LottoDomain.price = price ;

    }
    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        LottoDomain.price = price;
    }

    public static int getPlayLumber() {
        return playLumber;
    }

    public static void setPlayLumber(int playLumber) {
        LottoDomain.playLumber = playLumber;
    }

    public static List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static void setLottoNumbers(List<Integer> lottoNumbers) {
        LottoDomain.lottoNumbers = lottoNumbers;
    }
}