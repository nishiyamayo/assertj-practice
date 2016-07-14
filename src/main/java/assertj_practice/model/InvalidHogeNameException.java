package assertj_practice.model;

public class InvalidHogeNameException extends RuntimeException {

    public InvalidHogeNameException() {
        super("fuga is invalid name!!");
    }
}
