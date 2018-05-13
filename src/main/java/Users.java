public class Users {
    private int id;
    private String name;
    private int age;
    private String email;
    public Users(){
    }
    public Users(int id, String name, int age, String email){
        this.age=age;
        this.id=id;
        this.email=email;
        this.name=name;
    }
    public String toString(){
        return "Users ["+id+"\t"+name+"\t"+age+"\t"+email+"]";
    }


}
