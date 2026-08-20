package movieticketsystem;

class Seat {
    private String seatId;
    private String row;
    private int number;
    private SeatType seatType;
    private Screen screen;

    public Seat(String seatId, String row, int number, SeatType seatType,Screen screen) {
        this.seatId = seatId;
        this.row = row;
        this.number = number;
        this.seatType = seatType;
        this.screen = screen;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }
    
    public SeatType getSeatType() {
        return seatType;
    }

    public Screen getScreen() {
        return screen;
    }
}
