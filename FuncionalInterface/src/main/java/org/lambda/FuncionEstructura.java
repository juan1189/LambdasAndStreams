package org.lambda;

//Notacion que solo indica que es una interface de tipo funcional
//La teoria manda que es una interface funcional si solo tiene un metodo abstracto
//Pero se puede agregar metodos que pertenecen a la clase Object como "equals"
//Interface funcional: Permiten definir objetos que guardan funciones
@FunctionalInterface
public interface FuncionEstructura<T> {
    int comparar(T o1, T o2);

    boolean equals(Object obj);
}
