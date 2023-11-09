public class NewToy {
    //region Fields
    private ListToys newList = new ListToys();
    //endregion

    //region method creating toy and adding in the list
    public void newToy(String str) throws Exception{
        String [] arr = str.split(",");
        String name = arr[0];
        int weight = Integer.parseInt(arr[1]);
        Toy toy = new Toy(name,weight);
        newList.getToys().add(toy);
    }
    //endregion

    //region Getter
    public ListToys getNewList() {
        return newList;
    }
    //endregion
}
