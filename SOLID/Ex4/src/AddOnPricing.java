public interface AddOnPricing {
    boolean supports(AddOn a);
    Money price();
}