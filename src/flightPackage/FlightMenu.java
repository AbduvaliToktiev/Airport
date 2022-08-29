package flightPackage;

import java.util.List;
import java.util.Scanner;

public class FlightMenu {
    public static void start() {

        FlightMethods flightMethods = new FlightMethods();
        Flights flights = new Flights();

        boolean exitMainMenu = true;
        Scanner sc = new Scanner(System.in);
        while (exitMainMenu) {
            System.out.println("Меню рейсов: ");
            System.out.println("Добавление рейса");
            System.out.println("Удаление рейса");
            System.out.println("Изменение рейса");
            System.out.println("Поиск рейса по номеру");
            System.out.println("Вывод списка рейсов");
            System.out.println("Выход в главное меню");

            String choice = sc.nextLine();

            switch (choice) {
                case "Добавление рейса":
                    flightMethods.insertFlight(flights);
                    break;

                case "Удаление рейса":
                    flightMethods.deleteFlight(flights);
                    break;

                case "Изменение рейса":
                    flightMethods.updateFlight(flights);
                    break;

                case "Поиск рейса по номеру":
                    List<Flights> flightsListNumber = flightMethods.getFlightNumber(flights);
                    if (flightsListNumber.isEmpty()) {
                        try {
                            throw new ExceptionNoFlights("РЕЙСА НЕ СУЩЕСТВУЕТ!!!");
                        } catch (ExceptionNoFlights e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        for (Flights flightNumber : flightsListNumber) {
                            System.out.println(flightNumber);
                            System.out.println("---------");
                        }
                    }
                    break;

                case "Вывод списка рейсов":
                    List<Flights> flightsList = flightMethods.getFlightsFromDataBase();
                    if (flightsList.isEmpty()) {
                        System.out.println("EMPTY FLIGHTS");
                    } else {
                        for (Flights flight : flightsList) {
                            System.out.println(flight);
                            System.out.println("----------");
                        }
                    }
                    break;

                case "Выход в главное меню":
                    exitMainMenu = false;
                    break;

                default:
                    System.out.println("-------------------------------------------------------------");
                    System.err.println("Ошибка. Введите название из меню!!!");
            }
        }
    }
}
