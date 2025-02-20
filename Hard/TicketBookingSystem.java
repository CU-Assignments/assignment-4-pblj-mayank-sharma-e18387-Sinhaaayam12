import java.util.ArrayList;
import java.util.List;

class TicketBookingSystem {
    private List<Integer> availableSeats;
    private final Object lock = new Object(); // Lock object for synchronization

    public TicketBookingSystem(int numSeats) {
        availableSeats = new ArrayList<>();
        for (int i = 1; i <= numSeats; i++) {
            availableSeats.add(i);
        }
    }

    public void bookTicket(String passengerName, boolean isVIP) {
        Thread currentThread = Thread.currentThread();
        int priority = currentThread.getPriority();

        synchronized (lock) { // Synchronize on the lock object
            if (availableSeats.isEmpty()) {
                System.out.println(passengerName + " (Priority: " + priority + "): Sorry, no seats available.");
                return;
            }

            int seatNumber = availableSeats.remove(0); // Book the first available seat
            System.out.println(passengerName + " (Priority: " + priority + "): Booked seat number " + seatNumber);

            try {
                Thread.sleep(100); // Simulate booking process
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
            }

        }
    }

    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(10); // 10 available seats

        // Create threads for regular bookings
        Thread regularBooking1 = new Thread(() -> bookingSystem.bookTicket("Regular Passenger 1", false));
        Thread regularBooking2 = new Thread(() -> bookingSystem.bookTicket("Regular Passenger 2", false));
        Thread regularBooking3 = new Thread(() -> bookingSystem.bookTicket("Regular Passenger 3", false));

        // Create threads for VIP bookings
        Thread vipBooking1 = new Thread(() -> bookingSystem.bookTicket("VIP Passenger 1", true));
        Thread vipBooking2 = new Thread(() -> bookingSystem.bookTicket("VIP Passenger 2", true));

        // Set thread priorities (VIP has higher priority)
        vipBooking1.setPriority(Thread.MAX_PRIORITY);
        vipBooking2.setPriority(Thread.MAX_PRIORITY);
        regularBooking1.setPriority(Thread.NORM_PRIORITY);
        regularBooking2.setPriority(Thread.NORM_PRIORITY);
        regularBooking3.setPriority(Thread.NORM_PRIORITY);

        // Start the threads
        vipBooking1.start();
        vipBooking2.start();
        regularBooking1.start();
        regularBooking2.start();
        regularBooking3.start();

        try {
            vipBooking1.join();
            vipBooking2.join();
            regularBooking1.join();
            regularBooking2.join();
            regularBooking3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupt status
        }


        System.out.println("All bookings complete.");

    }
}
