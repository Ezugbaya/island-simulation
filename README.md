# Island Simulation 

com.javarush.istand

## **1. Пакеты и классы:**

#### 1)animal - Пакет с классами животных
- Animal

##### 1.1)predator
- Wolf - Волк (хищник)
- Boa - Удав (хищник)
- Fox - Лиса (хищник)
- Bear - Медведь (хищник)
- Eagle - Орел (хищник)

##### 1.2)herbivore
- Horse - Лошадь (травоядное)
- Deer - Олень (травоядное)
- Rabbit - Кролик (травоядное)
- Mouse - Мышь (травоядное)
- Goat - Коза (травоядное)
- Sheep - Овца (травоядное)
- Wild boar - Кабан (травоядное)
- Buffalo - Буйвол (травоядное)
- Duck - Утка (травоядное)
- Caterpillar - Гусеница (травоядное)

#### 2)config - Конфигурация 
- SimulationConfig - размер острова, тайминги
- AnimalConfig - характеристики животных
- EatMatrix - таблица вероятностей еды

#### 3)model - Модельные классы 
- Island - Остров (двумерный массив клеток - Location)
- Location - Клетка, содержит списки животных и растений 
- Plant - Растения
- Direction - Направление

#### 4)simulation - Логика симуляция
- SimpleSimulation - однопоточная
- MultiSimulation - многопоточная
- AnimalLifeTask - задача животных
- PlantGrowTask - задача растений
- StaticsTask - задача статики

App - Главный класс для запуска (точка входа)

## **2. Подключение зависимостей в pom.xml**