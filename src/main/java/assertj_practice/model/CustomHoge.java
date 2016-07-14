package assertj_practice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class CustomHoge extends Hoge {

    private List<Hoge> hoges;

    private CustomHoge(String name, Long value, Hoge...hoges) {
        if (name.contains("fuga")) {
            throw new InvalidHogeNameException();
        }
        setName(name);
        setValue(value);
        this.hoges = Arrays.asList(hoges);
    }

    public static CustomHoge of(String name, Long value, Hoge...hoges) {
        return new CustomHoge(name, value, hoges);
    }
}
