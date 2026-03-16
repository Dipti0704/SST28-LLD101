public class TripleRoomPricing implements RoomPricing {
    public boolean supports(int roomType) {
        return roomType == LegacyRoomTypes.TRIPLE;
    }
    public Money monthlyBase() {
        return new Money(12000);
    }
}