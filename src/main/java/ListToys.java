import java.util.ArrayList;
import java.util.List;

public class ListToys {
    //region Fields
    private List<Toy> toys = new ArrayList<>();
    //endregion

    //region Method Print all toys
    public void printAllToys()throws Exception{
        if(toys.size()>0) { // Проверяем список на пустоту
            for (Toy toy : this.toys) {
                System.out.println("\n" + toy);
            }
        }else{
            System.out.println("В вашем списке еще нет игрушек!");
            throw new RuntimeException(); // бросаем исключение для обработки поведения при пустом списке
        }
    }
    //endregion

    //region Getter
    public List<Toy> getToys() {
        return toys;
    }
    //endregion
}
