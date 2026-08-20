package movieticketsystem;

class ShowSeat {
    private String showseatId;
    private Seat seat;
    private Show show;
    private SeatStatus seatStatus;
    private String LockExpiryTime; // Optional: To track when the lock expires

    public ShowSeat(String showseatId, Seat seat, Show show) {
        this.showseatId = showseatId;
        this.seat = seat;
        this.show = show;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.LockExpiryTime = null; // Initially, no lock expiry time
    }

    public String getShowseatId() {
        return showseatId;
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public boolean isAvailable() {
        return seatStatus == SeatStatus.AVAILABLE;
    }

    public void lockSeat(String lockExpiryTime) {
        this.seatStatus = SeatStatus.LOCKED;
        this.LockExpiryTime = lockExpiryTime;
    }

    public void unlockSeat() {
        this.seatStatus = SeatStatus.AVAILABLE;
        this.LockExpiryTime = null; // Clear the lock expiry time
    }

    public void bookSeat() {
        this.seatStatus = SeatStatus.BOOKED;
        this.LockExpiryTime = null; // Clear the lock expiry time
    }
    
}
