public class DeluxeRoomPricing implements RoomPricing {
    public boolean supports(int roomType) {
        return roomType == LegacyRoomTypes.DELUXE;
    }
    public Money monthlyBase() {
        return new Money(16000);
    }
}