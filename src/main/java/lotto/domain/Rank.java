package lotto.domain;

import net.bytebuddy.dynamic.scaffold.TypeInitializer;


public enum Rank {
    FIRST(6,false,2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4,false,50000),
    FIFTH(3,false,5000);

    private int match_number;
    private boolean is_bouns_number;
    private int price;

    Rank(int match_number, boolean is_bouns_number, int price) {
        this.match_number = match_number;
        this.is_bouns_number = is_bouns_number;
        this.price = price;
    }
    public int getMatch_number() {
        return match_number;
    }
    public int getPrice() {
        return price;
    }
    public boolean get_is_bouns_number() {
        return is_bouns_number;
    }

    public static Rank check_Rank(int count, boolean is_bouns_number){
        for(Rank ranks:values()){
            if(check_number_And_bouns_number(ranks,count,is_bouns_number)) return ranks;
        }
        return null;
    }

    private static boolean check_number_And_bouns_number(Rank rank,int count, boolean is_bouns_number) {
        if(count==SECOND.match_number) return is_bouns_number==rank.get_is_bouns_number();
        return rank.getMatch_number()==count;
    }
}
