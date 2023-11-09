import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

public class Drawing {
    //region Fields
    private PriorityQueue queue = new PriorityQueue(Comparator.comparing(Toy::getWeight));
    //endregion

    //region Methods
    // Метод добавления существующего списка в очередь(через компаратор)
    public Boolean add (ListToys list){
        if(list.getToys().size()>0) {
            for (Toy toy : list.getToys()) {
                this.queue.offer(toy);
            }
            return true;
        }else{
            System.out.println("Список игрушек пуст, розыгрыш провести невозможно!");
            return false;
        }
    }

    //Запись в файл очередной игрушки и удаление ее из очереди и списка.
    public void toyDelivery(ListToys list){
        try {
            FileWriter fw = new FileWriter("result.txt", true);
            Date date = new Date();
            Toy toyWin = (Toy) queue.poll();
            fw.write(date.toString() +"\n");
            fw.write(toyWin.toString() + "\n");
            System.out.println("Разыгран " + toyWin.getName() +"\nЗапись произведена!");
            list.getToys().remove(toyWin);
            fw.close();
        } catch (IOException e) {}
    }
    //endregion

    //region Getter
    public PriorityQueue getQueue() {
        return queue;
    }
    //endregion
}
