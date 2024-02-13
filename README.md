# UD06Tarea4Polimorfismo
### Ejercicio 1
a) Querido Amy,
Saludos veraniegos!

Querido Bob,
Con amor y besos,
XXX

Querido Cindy,
Feliz 0 Aniversario

b) Las asignaciones correctas con c y v

### Ejercicio 4
a) rod = new Rat(); incorrecto

   mou = new Rat(); incorrecto

   rat = new Rodent(); correcto

   rat = new FieldMouse(); incorrecto

   rod = new FieldMouse(); incorrecto

   mou = new Rodent(); correcto

   rat = new LabRat(); correcto

   rat = new Mouse(); incorrecto
   
### Ejercicio 5
a) Una clase abstracta tiene constructor pero no se puede crear un objeto directamente a partir de una clase abstracta.

b) Una clase abstracta puede tener campos, metodos concretos y metodos abstractos, mientras que una interfaz solo puede tener métodos abstractos y constantes.

c) Si, utilizando la palabra clave implements para la interfaz y extends para la clase abstracta en la declaración.

### Ejercicio 6
// Clase abstracta Forma
public abstract class Forma {
    // Atributo
    protected int numLados;

    // Constructor
    public Forma(int numLados) {
        this.numLados = numLados;
    }

    // Getter para numLados
    public int getNumLados() {
        return numLados;
    }

    // Métodos abstractos
    public abstract double getArea();
    public abstract double getPerimeter();
}

// Subclase Rectángulo
public class Rectangulo extends Forma {
    // Atributos adicionales
    private double ancho;
    private double alto;

    // Constructor
    public Rectangulo(int numLados, double ancho, double alto) {
        super(numLados);
        this.ancho = ancho;
        this.alto = alto;
    }

    // Implementación de los métodos abstractos
    @Override
    public double getArea() {
        double area;
        area = ancho * alto;
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter;
        perimeter = 2 * (ancho + alto);
        return perimeter;
    }
}

// Subclase Triángulo
public class Triangulo extends Forma {
    // Atributos adicionales
    private double base;
    private double altura;

    // Constructor
    public Triangulo(int numLados, double base, double altura) {
        super(numLados);
        this.base = base;
        this.altura = altura;
    }

    // Implementación de los métodos abstractos
    @Override
    public double getArea() {
        double area;
        area = 0.5 * base * altura;
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = -1;
        // No proporciono una implementación específica para el perímetro de un triángulo,
        // ya que puede haber diferentes tipos de triángulos con cálculos de perímetro diferentes.
        return perimeter;
    }
}

// Clase con método main
public class Main {
    public static void main(String[] args) {
        // Crear un Rectángulo
        Rectangulo rectangulo = new Rectangulo(4, 5.0, 3.0);
        
        // Mostrar información del Rectángulo
        System.out.println("Rectángulo:");
        System.out.println("Número de lados: " + rectangulo.getNumLados());
        System.out.println("Área: " + rectangulo.getArea());
        System.out.println("Perímetro: " + rectangulo.getPerimeter());

        // Crear un Triángulo
        Triangulo triangulo = new Triangulo(3, 4.0, 6.0);
        
        // Mostrar información del Triángulo
        System.out.println("\nTriángulo:");
        System.out.println("Número de lados: " + triangulo.getNumLados());
        System.out.println("Área: " + triangulo.getArea());
        System.out.println("Perímetro: " + triangulo.getPerimeter());
    }
}
