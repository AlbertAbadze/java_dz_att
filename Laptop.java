import java.util.*;

public class Laptop {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    // Геттеры для полей

    public String getModel() {
        return model;
    }

    public int getRAM() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOS() {
        return os;
    }

    public String getColor() {
        return color;
    }

    // Метод для фильтрации списка ноутбуков

    public static List<Laptop> filterLaptops(List<Laptop> laptops, Map<Integer, Object> filters) {
        List<Laptop> filteredLaptops = new ArrayList<>();

        for (Laptop laptop : laptops) {
            boolean satisfiesFilters = true;

            for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                int criteria = entry.getKey();
                Object value = entry.getValue();

                switch (criteria) {
                    case 1: // ОЗУ
                        int minRAM = (int) value;
                        if (laptop.getRAM() < minRAM) {
                            satisfiesFilters = false;
                        }
                        break;

                    case 2: // Объем ЖД
                        int minStorage = (int) value;
                        if (laptop.getStorage() < minStorage) {
                            satisfiesFilters = false;
                        }
                        break;

                    case 3: // Операционная система
                        String os = (String) value;
                        if (!laptop.getOS().equals(os)) {
                            satisfiesFilters = false;
                        }
                        break;

                    case 4: // Цвет
                        String color = (String) value;
                        if (!laptop.getColor().equals(color)) {
                            satisfiesFilters = false;
                        }
                        break;

                    // Добавьте дополнительные критерии фильтрации, если необходимо

                    default:
                        break;
                }

                if (!satisfiesFilters) {
                    break;
                }
            }

            if (satisfiesFilters) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }

    public static void main(String[] args) {
			List<Laptop> laptops = new ArrayList<>();
			laptops.add(new Laptop("MSI", 8, 512, "Windows", "Black"));
			laptops.add(new Laptop("Apple", 16, 1024, "MacOS", "Silver"));
			laptops.add(new Laptop("HP", 16, 512, "Windows", "Black"));
			laptops.add(new Laptop("Asus", 8, 256, "Linux", "White"));
	
			Scanner scanner = new Scanner(System.in);
	
			Map<Integer, Object> filters = new HashMap<>();
	
			System.out.println("Введите критерии фильтрации:");
			System.out.println("1 - ОЗУ");
			System.out.println("2 - Объем ЖД");
			System.out.println("3 - Операционная система");
			System.out.println("4 - Цвет");
	
			int criteria = scanner.nextInt();
	
			switch (criteria) {
					case 1:
							System.out.println("Введите минимальное значение ОЗУ:");
							int minRAM = scanner.nextInt();
							filters.put(1, minRAM);
							break;
					case 2:
							System.out.println("Введите минимальный объем ЖД:");
							int minStorage = scanner.nextInt();
							filters.put(2, minStorage);
							break;
					case 3:
							System.out.println("Введите операционную систему:");
							String os = scanner.next();
							filters.put(3, os);
							break;
					case 4:
							System.out.println("Введите цвет:");
							String color = scanner.next();
							filters.put(4, color);
							break;
					default:
							System.out.println("Некорректный критерий фильтрации.");
							return;
			}
	
			List<Laptop> filteredLaptops = filterLaptops(laptops, filters);
	
			System.out.println("Результаты фильтрации:");
			for (Laptop laptop : filteredLaptops) {
					System.out.println("Модель: " + laptop.getModel() +
									", ОЗУ: " + laptop.getRAM() +
									", ЖД: " + laptop.getStorage() +
									", ОС: " + laptop.getOS() +
									", Цвет: " + laptop.getColor());
			}
	}	
}
