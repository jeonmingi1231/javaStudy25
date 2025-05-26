package ch04.marioKart.dto;

public class CartDTO {
    public String name;
    public double speed;
    public double acceleration;
    public double handling;
    public double weight;

    public CartDTO(String name, double speed, double acceleration, double handling, double weight) {
        this.name = name;
        this.speed = speed;
        this.acceleration = acceleration;
        this.handling = handling;
        this.weight = weight;
    }

    public void display() {
        System.out.println("카트 이름: " + name);
        System.out.println("속도: " + speed);
        System.out.println("가속: " + acceleration);
        System.out.println("핸들링: " + handling);
        System.out.println("무게: " + weight);
        System.out.println("---------------------------");
    }
}
