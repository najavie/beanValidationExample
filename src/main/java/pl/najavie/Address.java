package pl.najavie;

import javax.validation.constraints.NotNull;

public class Address {

    @NotNull
    private String address;

    public Address(@NotNull String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
