public class DoubleRoomPricing implements RoomPricing {
    public boolean supports(int roomType) {
        return roomType == LegacyRoomTypes.DOUBLE;
    }
    public Money monthlyBase() {
        return new Money(15000);
    }
}