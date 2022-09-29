package util;

public class Hall {

    private int roomNumber;
    private int capacity;
    private int floor;

    public Hall(int roomNumber, int capacity, int floor) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFloor() {
        return floor;
    }
}
