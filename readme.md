- https://bypass.hix.ai/
- https://app.gptzero.me/
- https://excalidraw.com/
- https://temp-mail.org/en/view/679e17a06803b900139b1b24 : mimav56237@ahaks.com
- 


Create a Decorator design pattern component diagram for the Coffee example.
Component = Coffee
Operation => GetDescription, GetCost

ConcreateComponent => BasicCoffee
Decorator = CoffeeDecorator
ConcreateDecorator = MilkDecorator, SugarDecorator, ChocolateDecorator

classDiagram
class Coffee {
<<interface>>
+GetDescription() string
+GetCost() float
}
class BasicCoffee {
+GetDescription() string
+GetCost() float
}
class CoffeeDecorator {
<<abstract>>
-coffee Coffee
+GetDescription() string
+GetCost() float
}
class MilkDecorator {
+GetDescription() string
+GetCost() float
}
class SugarDecorator {
+GetDescription() string
+GetCost() float
}
class ChocolateDecorator {
+GetDescription() string
+GetCost() float
}

    Coffee <|.. BasicCoffee
    Coffee <|.. CoffeeDecorator
    CoffeeDecorator <|-- MilkDecorator
    CoffeeDecorator <|-- SugarDecorator
    CoffeeDecorator <|-- ChocolateDecorator
    CoffeeDecorator o-- Coffee


classDiagram
class Component {
<<interface>>
+operation()
}
class ConcreteComponent {
+operation()
}
class Decorator {
<<abstract>>
-Component component
+operation()
}
class ConcreteDecorator1 {
+operation()
}
class ConcreteDecorator2 {
+operation()
}
class ConcreteDecoratorN {
+operation()
}

    Component <|.. ConcreteComponent
    Component <|.. Decorator
    Decorator <|-- ConcreteDecorator1
    Decorator <|-- ConcreteDecorator2
    Decorator <|-- ConcreteDecoratorN
    Decorator o-- Component
