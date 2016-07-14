package assertj_practice;

import assertj_practice.model.Hoge;
import assertj_practice.service.HogeService;

public class Main {

    public static void main(String[] args) {
        new HogeService().hogeFilter(Hoge.of("", 100L));
    }
}
