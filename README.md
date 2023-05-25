<h1>Сортировка моделей ноутбука</h1>

Этот пример реализует класс Laptop, содержащий поля для модели, ОЗУ, объема жесткого диска, операционной системы и цвета ноутбука. Метод filterLaptops принимает список ноутбуков и фильтры в виде Map<Integer, Object>, где ключ - это критерий фильтрации (например, 1 для ОЗУ, 2 для объема ЖД и т.д.), а значение - минимальное значение, которому должно соответствовать поле ноутбука. Метод выполняет фильтрацию и возвращает список отфильтрованных ноутбуков.

В методе main создается список ноутбуков и фильтр для демонстрации использования метода filterLaptops. Результаты фильтрации выводятся на консоль.

Вы можете добавить или изменить критерии фильтрации и дополнительные поля в классе Laptop, а также настроить соответствующую логику в методе filterLaptops в соответствии с вашими потребностями.