package pojos;

public class BookingDatesPojo {

    // 1) Tüm keyler için private variableler oluşturuyoruz
    private String checkin;
    private String checkout;

    // 2) Tüm parametrelerle ve parametresiz constructorlar oluşturuyoruz

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    // 3) Public Getter ve Setter methodlarini oluşturuyoruz

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    // 4) toString() methodunu oluşturacağız

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
