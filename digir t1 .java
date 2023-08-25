import java.util.ArrayList;
import java.util.List;

class Flight {
    private String flightNumber;
    private String origin;
    private String destination;

    public Flight(String flightNumber, String origin, String destination) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
}

class Reservation {
    private String passengerName;
    private Flight flight;

    public Reservation(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Flight getFlight() {
        return flight;
    }
}

class AirlineReservationSystem {
    private List<Flight> flights;
    private List<Reservation> reservations;

    public AirlineReservationSystem() {
        flights = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public void makeReservation(String passengerName, String flightNumber) {
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            Reservation reservation = new Reservation(passengerName, flight);
            reservations.add(reservation);
            System.out.println("Reservation made for " + passengerName + " on flight " + flightNumber);
        } else {
            System.out.println("Flight " + flightNumber + " not found.");
        }
    }

    public void cancelReservation(String passengerName, String flightNumber) {
        reservations.removeIf(reservation -> 
            reservation.getPassengerName().equals(passengerName) && 
            reservation.getFlight().getFlightNumber().equals(flightNumber));
        System.out.println("Reservation canceled for " + passengerName + " on flight " + flightNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        AirlineReservationSystem reservationSystem = new AirlineReservationSystem();

        Flight flight1 = new Flight("AI123", "New Delhi", "Mumbai");
        Flight flight2 = new Flight("UA456", "New York", "Los Angeles");

        reservationSystem.addFlight(flight1);
        reservationSystem.addFlight(flight2);

        reservationSystem.makeReservation("Tushar", "AI123");
        reservationSystem.makeReservation("Alice", "UA456");

        reservationSystem.cancelReservation("Tushar", "AI123");

        //   
    }
}
