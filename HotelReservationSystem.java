import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Room[] rooms = {
            new Room(101, "Classic", 2000),
            new Room(102, "Deluxe", 3500),
            new Room(103, "Premium", 5000)
        };

        int choice;

        do {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");

                    for(Room room : rooms) {
                        System.out.println(
                            room.roomNumber + " | " +
                            room.category + " | $" +
                            room.price + " | " +
                            (room.booked ? "Booked" : "Available")
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int bookRoom = sc.nextInt();

                    boolean found = false;

                    for(Room room : rooms) {

                        if(room.roomNumber == bookRoom) {

                            found = true;

                            if(!room.booked) {

                                System.out.println("Payment Amount: $" + room.price);
                                System.out.println("Payment Successful!");

                                room.booked = true;

                                System.out.println("Room Booked Successfully!");
                            }
                            else {
                                System.out.println("Room already booked!");
                            }
                        }
                    }

                    if(!found)
                        System.out.println("Room not found!");

                    break;

                case 3:
                    System.out.print("Enter room number: ");
                    int cancelRoom = sc.nextInt();

                    for(Room room : rooms) {

                        if(room.roomNumber == cancelRoom) {

                            if(room.booked) {
                                room.booked = false;
                                System.out.println("Booking Cancelled!");
                            }
                            else {
                                System.out.println("Room is not booked.");
                            }
                        }
                    }
                    break;

                case 4:

                    System.out.println("\nBooked Rooms:");

                    for(Room room : rooms) {

                        if(room.booked) {
                            System.out.println(
                                room.roomNumber + " | " +
                                room.category + " | $" +
                                room.price
                            );
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 5);

        sc.close();
    }
}