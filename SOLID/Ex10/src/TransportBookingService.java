public class TransportBookingService {
    // DIP violation: direct concretes
    private final DistanceService dist;
    private final DriverAllocatorService alloc;
    private final PaymentService pay;
    private final FareCalculator fareCalc;

    public TransportBookingService(
            DistanceService dist,
            DriverAllocatorService alloc,
            PaymentService pay,
            FareCalculator fareCalc
    ) {
        this.dist = dist;
        this.alloc = alloc;
        this.pay = pay;
        this.fareCalc = fareCalc;
    }

    public void book(TripRequest req) {
       

        double km = dist.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = alloc.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = fareCalc.calculate(km);

        String txn = pay.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
