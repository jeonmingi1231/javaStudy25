package ch04.marioKart.dto;

public class CharacterDTO {
    public String name;
    public double speed;
    public double acceleration;
    public double handling;
    public double weight;
    public double traction;

    public CharacterDTO(String name, double speed, double acceleration, double handling, double weight, double traction) {
        this.name = name;
        this.speed = speed;
        this.acceleration = acceleration;
        this.handling = handling;
        this.weight = weight;
        this.traction = traction;
    }

    public void display() {
        System.out.println("캐릭터 이름: " + name);
        System.out.println("속도: " + speed);
        System.out.println("가속: " + acceleration);
        System.out.println("핸들링: " + handling);
        System.out.println("무게: " + weight);
        System.out.println("접지력: " + traction);
        System.out.println("---------------------------");
    }
}
