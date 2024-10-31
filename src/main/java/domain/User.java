package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int amount;
    private double rateOfReturn;
    private List<Lotto> lottos;

    public User(int amount) {
        this.amount = amount;
        this.rateOfReturn = 0.0;
        this.lottos = new ArrayList<>();
    }
}
