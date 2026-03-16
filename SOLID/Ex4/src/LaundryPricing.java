public class LaundryPricing implements AddOnPricing {
    public boolean supports(AddOn a) {
        return a == AddOn.LAUNDRY;
    }
    public Money price() {
        return new Money(500);
    }
}