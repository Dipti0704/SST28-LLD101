public class MessPricing implements AddOnPricing {
    public boolean supports(AddOn a) {
        return a == AddOn.MESS;
    }
    public Money price() {
        return new Money(1000);
    }
}