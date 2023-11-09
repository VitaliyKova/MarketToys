public class Toy {
    //region Fields
    private  Integer id;
    private static Integer count = 1;
    private String name;
    private Integer weight;
    //endregion

    //region Constructor
    public Toy(String name, Integer weight) {
        this.id = count++; //Каждый раз увеличиваем будущий id
        this.name = name;
        this.weight = weight;
    }
    //endregion

    //region Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    //endregion

    //region To String
    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.weight;
    }
    //endregion
}
