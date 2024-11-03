package lotto.data;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Lotto> purchaseLottoList = new ArrayList<>();
    public static Result result = new Result();

    public static List<Lotto> getPurchaseLottoList() {
        return purchaseLottoList;
    }

    public static Result getResult() {
        return result;
    }
}
