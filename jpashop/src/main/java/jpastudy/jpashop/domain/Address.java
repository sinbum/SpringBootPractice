package jpastudy.jpashop.domain;

import javax.persistence.Embeddable;
//다른패키지에서 사용하지 말라는 으믜로 타 개발자와 커뮤니케이션을 위해서 이렇게 설정하는 이유임.
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zip;

    public Address(String city, String street, String zip) {
        this.city = city;
        this.street = street;
        this.zip = zip;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getCity() {
        return this.city;
    }

    @SuppressWarnings("all")
    public String getStreet() {
        return this.street;
    }

    @SuppressWarnings("all")
    public String getZip() {
        return this.zip;
    }

    @SuppressWarnings("all")
    protected Address() {
    }
    //</editor-fold>
}
