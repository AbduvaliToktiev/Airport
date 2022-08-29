package countryPackage;

import airportPackage.Airports;

import java.util.List;
import java.util.Scanner;

public class CountryMenu {
    public static void start() {

        CountryMethods countryMethods = new CountryMethods();
        Countries countries = new Countries();
        Airports airports = new Airports();

        boolean exitMainMenu = true;
        Scanner sc = new Scanner(System.in);
        while (exitMainMenu) {
            System.out.println("Меню стран: ");
            System.out.println("Добавление страны");
            System.out.println("Удаление страны");
            System.out.println("Изменение аэропорта по коду страны");
            System.out.println("Поиск страны по коду");
            System.out.println("Вывод списка стран");
            System.out.println("Выход в главное меню");

            String choice = sc.nextLine();

            switch (choice) {
                case "Добавление страны":
                    countryMethods.insertCountry(countries);
                    break;

                case "Удаление страны":
                    countryMethods.deleteCountry(countries);
                    break;

                case "Изменение аэропорта по коду страны":
                    countryMethods.updateAirportOnCountryCode(airports);
                    break;

                case "Поиск страны по коду":
                    List<Countries> countriesList = countryMethods.selectCountryOnCodeCountry(countries);
                    if (countriesList.isEmpty()) {
                        try {
                            throw new ExceptionDeleteAndFrom("СТРАНЫ С ПОДОБНЫМ КОДОМ НЕ СУЩЕСТВУЕТ!");
                        } catch (ExceptionDeleteAndFrom e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        for (Countries country : countriesList) {
                            System.out.println(country);
                            System.out.println("----------");
                        }
                    }
                    break;

                case "Вывод списка стран":
                    List<Countries> countriesListAll = countryMethods.getCountriesFromDataBase();
                    if (countriesListAll.isEmpty()) {
                        System.out.println("EMPTY COUNTRIES");
                    } else {
                        for (Countries country : countriesListAll) {
                            System.out.println(country);
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
