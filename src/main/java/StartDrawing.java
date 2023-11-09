import java.util.Scanner;

public class StartDrawing {

    //region Fields
    private NewToy newToy = new NewToy();

    private String menu = "\n1 -> Добавить новую игрушку."+
            "\n2 -> Удалить игрушку."+
            "\n3 -> Изменить частоту выпадения игрушки."+
            "\n4 -> Провести розыгрыш."+
            "\n5 -> Exit";
    private String userInput = "\nВведите данные об игрушке в формате(Название,Вес)\n" +
            "ПРИМЕЧАНИЯ\n"+
            "Название -> строка(латиница или кириллица)\n" +
            "Вес -> любое целое число\n";
    private String searchId = "\nВведите Id игрушки";
    //endregion

    //region UserOperation
    public void start(){
        Scanner sc = new Scanner(System.in);
        Boolean flag = true;
        while(flag){
            System.out.println(this.menu);
            String oper = sc.nextLine();
            switch (oper){
                //region case 1 (Добавление новой игрушки в список)
                case "1":
                    System.out.println(this.userInput);
                    String temp = sc.nextLine();
                    try {
                        newToy.newToy(temp);
                        System.out.println("Успешно!");
                    } catch (Exception e) {
                        System.out.println("Данные введены некорректно!");
                    }
                    break;
                //endregion
                //region case2 (Удаление игрушки из списка по id)
                case"2":
                    try {
                        newToy.getNewList().printAllToys();
                    } catch (Exception e) {
                        System.out.println("Выберите 1, чтобы добавить игрушку!"); // Обработка в случае пустого списка
                        break;
                    }
                    System.out.println(searchId);
                    try {  // Проверка корректности введенных данных
                        Integer num = Integer.parseInt(sc.nextLine());
                        Boolean indicator = false;
                        for (int i = 0; i < newToy.getNewList().getToys().size(); i++) {
                            Toy toy = newToy.getNewList().getToys().get(i);
                            if (toy.getId() == num) {
                                newToy.getNewList().getToys().remove(toy);
                                indicator = true;
                                System.out.println("Успешно удалено!");
                            }
                        }
                        if(indicator == false){
                            System.out.println("Игрушка с таким id не найдена");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Введен некорректный id!");
                    }
                    break;
                //endregion
                //region case3 (Редактирование частоты выпадения игрушки)
                case "3":
                    try {
                        newToy.getNewList().printAllToys();
                    } catch (Exception e) {
                        System.out.println("Выберите 1, чтобы добавить игрушку!"); // Обработка в случае пустого списка
                        break;
                    }
                    System.out.println(searchId);
                    try {
                        Integer num = Integer.parseInt(sc.nextLine());
                        Boolean indicator = false;
                        for (int i = 0; i < newToy.getNewList().getToys().size(); i++) {
                            Toy toy = newToy.getNewList().getToys().get(i);
                            if (toy.getId() == num) {
                                System.out.println("\nВведите новую частоту выпадения игрушки");
                                try {
                                    Integer newValue = Integer.parseInt(sc.nextLine());
                                    toy.setWeight(newValue);
                                    System.out.println("Успешно изменено!");
                                    indicator = true;
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Введено некорректное значение");
                                }
                            }
                        }
                        if(indicator == false) {
                            System.out.println("Игрушка с таким id не найдена");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Введен некорректный id!");
                    }
                    break;
                //endregion
                //region case4 (Проведение розыгрыша)
                case "4":
                    Drawing drawing = new Drawing();
                    if(drawing.add(newToy.getNewList()) == true){
                        drawing.toyDelivery(newToy.getNewList()); // если удалось заполнить очередь для розыгрыша
                    }
                    break;
                //endregion
                //region case 5 (Остановка программы)
                case "5":
                    flag = false;
                    break;
                //endregion
            }
        }
    }
    //endregion
}
