package mainPackage;

import airportPackage.AirportMenu;
import clientPackage.CustomerMenu;
import countryPackage.CountryMenu;
import flightPackage.FlightMenu;
import ticketPackage.TicketMenu;

import java.util.Scanner;

public class MainMenu {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Главное меню: ");
            System.out.println("Работа с рейсами");
            System.out.println("Работа со странами");
            System.out.println("Работа с аэропортами");
            System.out.println("Работа с клиентами");
            System.out.println("Работа с билетами");
            System.out.println("Выход из программы");

            String choice = sc.nextLine();

            switch (choice) {
                case "Работа с рейсами" -> FlightMenu.start();
                case "Работа со странами" -> CountryMenu.start();
                case "Работа с аэропортами" -> AirportMenu.start();
                case "Работа с клиентами" -> CustomerMenu.start();
                case "Работа с билетами" -> TicketMenu.start();
                case "Выход из программы" -> System.exit(0);
                default -> {
                    System.out.println("-------------------------------------------------------------");
                    System.err.println("Ошибка. Введите название из меню!!!");
                }
            }
        }
    }
}
