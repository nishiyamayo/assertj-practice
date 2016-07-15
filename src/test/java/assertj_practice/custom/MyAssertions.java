package assertj_practice.custom;

import assertj_practice.model.CustomHoge;
import assertj_practice.model.CustomHogeAssert;
import assertj_practice.model.Hoge;
import assertj_practice.model.HogeAssert;
import org.assertj.core.api.Assertions;

public class MyAssertions extends Assertions {

    public static HogeAssert assertThat(Hoge actual) {
        return new HogeAssert(actual);
    }

    public static CustomHogeAssert assertThat(CustomHoge actual) {
        return new CustomHogeAssert(actual);
    }
}
