package airportPackage;

import java.util.List;
import java.util.Scanner;

public class AirportMenu {
    public static void start() {

        AirportMethods airportMethods = new AirportMethods();
        Airports airports = new Airports();

        boolean exitMainMenu = true;
        Scanner sc = new Scanner(System.in);
        while (exitMainMenu) {
            System.out.println("Меню аэропортов: ");
            System.out.println("Добавление аэропорта");
            System.out.println("Удаление аэропорта");
            System.out.println("Изменение аэропорта");
            System.out.println("Поиск аэропорта по коду");
            System.out.println("Вывод списка аэропортов");
            System.out.println("Выход в главное меню");

            String choice = sc.nextLine();

            switch (choice) {
                case "Добавление аэропорта":
                    airportMethods.insertAirport(airports);
                    break;

                case "Удаление аэропорта":
                    airportMethods.deleteAirport(airports);
                    break;

                case "Изменение аэропорта":
                    airportMethods.updateAirport(airports);
                    break;

                case "Поиск аэропорта по коду":
                    List<Airports> airportsCodeList = airportMethods.selectAirportOnAirportCode(airports);
                    if (airportsCodeList.isEmpty()) {
                        try {
                            throw new ExceptionNoAirportCode("АЭРОПОРТА С ДАННЫМ КОДОМ НЕ СУЩЕСТВУЕТ!!!");
                        } catch (ExceptionNoAirportCode e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        for (Airports airport : airportsCodeList) {
                            System.out.println(airport);
                            System.out.println("----------");
                        }
                    }
                    break;

                case "Вывод списка аэропортов":
                    List<Airports> airportsListAll = airportMethods.getAirportsFromDataBase();
                    if (airportsListAll.isEmpty()) {
                        System.out.println("EMPTY AIRPORTS");
                    } else {
                        for (Airports airportsAll : airportsListAll) {
                            System.out.println(airportsAll);
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
