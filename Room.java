class Room {
    int roomNumber;
    String category;
    double price;
    boolean booked;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.booked = false;
    }
}