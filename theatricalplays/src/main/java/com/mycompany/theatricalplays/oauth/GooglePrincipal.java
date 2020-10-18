package com.mycompany.theatricalplays.oauth;

import java.math.BigInteger;


// model pou xrhsimopoieitai gia na apo8hkeuetai to client id pou dinei to Google People API
public class GooglePrincipal {
    private final BigInteger id;
    private String email;

    public GooglePrincipal(BigInteger id) {
        this.id = id;
    }

    public GooglePrincipal(BigInteger id, String email) {
        this.id = id;
        this.email = email;
    }
    public BigInteger getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GooglePrincipal that = (GooglePrincipal) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GooglePrincipal{" +
                "id=" + id +
                "email=" + email +
                '}';
    }
}
