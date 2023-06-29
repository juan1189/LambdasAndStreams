#¿Qué es una expresión Lambda?

Una expresión lambda es esencialmente una función sin nombre, que tiene un cuerpo de función y puede o no recibir parámetros.

En Java, una expresión lambda siempre va a representar el método abstracto de una interfaz funcional.

La expresión lambda va a separar su lista de parámetros de su cuerpo de función por medio del operador flecha ->

Una expresión lambda luce así.

(argumentos) -> 
{
    //cuerpo de la expresión lambda
}

#¿Qué es una interfaz funcional?

Antes de hablar de las interfaces funcionales, comentaré brevemente las novedades en las interfaces en general que la versión 8 de Java ha implementado.

La primera y mas impresionante característica es que ahora las interfaces permiten tener una implementación por defecto para sus métodos. Si un método de una interfaz tiene alguna implementación, es necesario declarar ese método como default. La idea es que todas las clases que implementen esta interfaz tengan cierta funcionalidad "por defecto" en los métodos de sus interfaces.

Una interfaz puede tener cualquier cantidad de métodos implementados siempre y cuando sean declarados como default.

public interface Iterable<T> {
    Iterator<T> iterator();
    
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
}
La otra característica es que las interfaces pueden tener métodos estáticos implementados.

import java.util.List;
 
public interface Producto {
 
    public int getPrecio();
     
    public static int importeTotal(List<Producto> listaProductos) {
         
        return listaProductos.stream().mapToInt((p)->p.getPrecio()).sum();
    }
}
En cuanto a los métodos abstractos, no hay cambios; las interfaces pueden tener cualquier cantidad de métodos abstractos "en sus filas".

Entonces, ¿Qué es una interfaz funcional?

Las interfaces funcionales se utilizan principalmente para permitir el paso de funciones a métodos. Esto es, que podemos pasar una implementación de una función como argumento de un método.

En el fondo, seguiremos pasando un objeto a dicho método, pero la idea de la interfaz funcional (y de la programación funcional en sí) es trabajar con funciones mas que con objetos. La interfaz funcional nos va a permitir simular que pasamos una función implementada como argumento de un método, aunque no es su único uso.

Cuando profundicemos más en las expresiones lambda, entenderemos mejor este concepto que a primera instancia puede ser confuso para los programadores que estamos acostumbrados a trabajar con objetos.

Para que una interfaz sea funcional debe cumplir con un solo requisito: Solo debe tener un método abstracto.

La interfaz funcional puede tener varios métodos estáticos y default si quiere, pero solo un método abstracto.

Más adelante veremos que esta característica le permite acoplarse perfectamente con las expresiones lambda.

Es posible para nosotros crear nuestras propias interfaces funcionales, sin embargo, la versión 8 de Java ha incluido una gran cantidad de estas interfaces dentro del paquete java.util.function 
