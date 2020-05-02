package me.suski;

import java.util.*;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }


    public Theatre(String theatreName, int numRows,
                   int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.0;
                if (row < 'D' && seatNum>= 4 && seatNum <= 9) {
                    price = 14;
                } else if (row > 'F' || seatNum <4 || seatNum >9) {
                    price = 7;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum),
                        price);
                seats.add(seat);
            }
        }


    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("No seat " + seatNumber);
            return false;
        }
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        Seat(String seatNumber, double price) {
            this.price = price;
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber +
                        " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat number  " +
                        seatNumber + " canceled");
                return true;
            } else {
                return false;
            }
        }

        String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}
