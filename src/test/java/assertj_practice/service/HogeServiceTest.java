package assertj_practice.service;

import assertj_practice.model.Hoge;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HogeServiceTest {

    @Test
    public void testAssertThat() {
        assertThat(Hoge.of("hoge", 100L))
            .isEqualTo(Hoge.of("hoge", 100L));
    }
}
