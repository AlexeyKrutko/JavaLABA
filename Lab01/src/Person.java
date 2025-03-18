import java.util.Random;

public class Person {
    private String name;
    private int age;
    private String profession;

    public void eat() {
        System.out.print("Люблю повеселиться - особенно поесть\n");
    }


    public void sing()
    {
        System.out.print("Радоваться жизни самой...\n");
    }
    public void introduceYourself() {
        System.out.println("Привет! Меня зовут " + name + ". Мне " + age + " лет, и я работаю " + profession + ".");
    }
    //Конструктор
  public Person(String name, int age, String profession) {
       this.name = name;
      this.age = age;
      this.profession = profession;
   }

   public Person(String name)
   {
       this.name=name;
   }
    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String newName) {
       this.name = newName;
       // name=newName;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


}
