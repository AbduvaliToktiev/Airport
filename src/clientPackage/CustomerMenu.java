package clientPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    public static void start() {

        ClientMethods clientMethods = new ClientMethods();
        Clients clients = new Clients();

        boolean exitMainMenu = true;
        Scanner sc = new Scanner(System.in);
        while (exitMainMenu) {
            System.out.println("Меню клиентов: ");
            System.out.println("Добавление клиента");
            System.out.println("Удаление клиента");
            System.out.println("Изменение клиента");
            System.out.println("Поиск клиента по номеру паспорта");
            System.out.println("Вывод списка клиентов");
            System.out.println("Выход в главное меню");

            String choice = sc.nextLine();

            switch (choice) {
                case "Добавление клиента":
                    clientMethods.insertClients(clients);
                    break;

                case "Удаление клиента":
                    clientMethods.deleteClient(clients);
                    break;

                case "Изменение клиента":
                    clientMethods.updateClient(clients);
                    break;

                case "Поиск клиента по номеру паспорта":
                    List<Clients> clientsList = clientMethods.getClientAndCountry(clients);
                    if (clientsList.isEmpty()) {
                        try {
                            throw new ExceptionNoClient("КЛИЕНТА С ДАННЫМ НОМЕРОМ НЕ СУЩЕСТВУЕТ!!!");
                        } catch (ExceptionNoClient e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        for (Clients client : clientsList) {
                            System.out.println(client);
                            System.out.println("----------");
                        }
                    }
                    break;

                case "Вывод списка клиентов":
                    List<Clients> clientsListAll = clientMethods.getAllClientFromDataBase();
                    if (clientsListAll.isEmpty()) {
                        System.out.println("EMPTY CLIENTS");
                    } else {
                        for (Clients client: clientsListAll) {
                            System.out.println(client);
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
