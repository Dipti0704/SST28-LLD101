public class GymPricing implements AddOnPricing {
    public boolean supports(AddOn a) {
        return a == AddOn.GYM;
    }
    public Money price() {
        return new Money(300);
    }
}