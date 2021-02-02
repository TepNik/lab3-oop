package phonebook;

import java.util.Objects;


public final class PhoneNumber {
    private String number;
    private String type;

    public PhoneNumber(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public final String getNumber() {
        return number;
    }

    public final void setNumber(String number) {
        this.number = number;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "PhoneNumber(number=" + this.number + ", type=" + this.type + ")";
    }

    public int hashCode() {
        return Objects.hash(number, type);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PhoneNumber && number.equals(((PhoneNumber) other).number)
                && type.equals(((PhoneNumber) other).type);
    }
}