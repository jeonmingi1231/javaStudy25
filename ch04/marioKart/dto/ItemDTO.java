package ch04.marioKart.dto;

public class ItemDTO {
    public String name;
    public String effect;

    public ItemDTO(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public void display() {
        System.out.println("아이템 이름: " + name);
        System.out.println("효과: " + effect);
        System.out.println("---------------------------");
    }
}
