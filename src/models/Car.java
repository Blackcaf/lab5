package models;

/**
 * Класс, представляющий машину.
 */
public class Car {
    private String name; // Может быть null
    private boolean cool;

    public Car(String name, boolean cool) {
        this.name = name;
        this.cool = cool;
    }

    public String getName() {
        return name;
    }

    public boolean isCool() {
        return cool;
    }

    @Override
    public String toString() {
        return "Car{name='" + name + "', cool=" + cool + "}";
    }
}

//package models;
//
//import java.util.Objects;
//
///**
// * Класс, представляющий машину.
// */
//public class Car {
//    private String name; // Может быть null
//    private boolean cool;
//
//    public Car(String name, boolean cool) {
//        this.name = name;
//        this.cool = cool;
//    }
//
//    public Car() {
//        this.name = null;
//        this.cool = false;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public boolean isCool() {
//        return cool;
//    }
//
//    public void setCool(boolean cool) {
//        this.cool = cool;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return cool == car.cool && Objects.equals(name, car.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, cool);
//    }
//
//    @Override
//    public String toString() {
//        return "Car{name='" + name + "', cool=" + cool + "}";
//    }
//}
