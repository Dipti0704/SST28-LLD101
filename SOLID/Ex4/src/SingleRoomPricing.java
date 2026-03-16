public class SingleRoomPricing implements RoomPricing {
    public boolean supports(int roomType) {
        return roomType == LegacyRoomTypes.SINGLE;
    }
    public Money monthlyBase() {
        return new Money(14000);
    }
}