package org.lambda;

public class Main {
    public static void main(String[] args) {

        System.out.println("----- Funcion sin parametros -----");
        //Sin Param: forma de invocar a la implementacion sin parametro
        FuncionSinParam ft = () -> System.out.println("Hola Mundo");
        ft.saludar();

        //Sin Param: forma de invocar, se envia por parametro la implementación
        Main a = new Main();
        a.miMetodo(ft);

        System.out.println("----- Funcion con parametros -----");

        //Con Param: Se implementa y se invoca al metodo abstracto para enviar los valores
        FuncionConParam fp = (num1, num2) -> System.out.println(num1+num2);
        fp.imprimeSuma(10,2);

        //Con Param: Forma de invocar a una funcion con parametros
        a.miMetoFP(fp,9,20);

        //Con Param: Forma donde puedo modificar la implementacion de la function lambda
        a.miMetoFP((num1,num2)-> System.out.println(num1-num2),10,2);

        System.out.println("----- Funcion con return -----");

        //Con Return: envia la implementación y el metodo abstracto devolvera el resultado
        engine((x,y)-> x + y);
        engine((x,y)-> x * y);
        engine((x,y)-> x % y);

        System.out.println("----- Parametros ambiguos -----");
        calcular((long x, long y) -> x + y);
        calcular((FuncionTipoLong) (x,y)-> x + y); //Se puede castear con la interface para evitar ambiguedad

        FuncionTipoLong fLong = (x,y) -> x + y;
        FuncionTipoInt fInt = (x,y) -> x + y;

        calcular(fLong);
        calcular(fInt);

        System.out.println("----- Retornando un funcion lambda -----");
        System.out.println(crear().calcular(10,2));

        //scope de las variables de lambda
        //Las variables creadas dentro de un metodo o funcion pueden usarse
        //dentro de la expresión lamda, sin embargo las variables de la funcion
        //lambda no pueden usarse fuera.
    }

    private static FuncionTipoLong crear(){
        return (x, y) -> x / y;
    }

    public void miMetodo(FuncionSinParam param){
        param.saludar();
    }

    public void miMetoFP(FuncionConParam param, int num1, int num2){
        param.imprimeSuma(num1,num2);
    }

    public static void engine(FuncionConReturn cal){
        int x = 2 , y = 3;
        int result = cal.calcular(x,y);
        System.out.println(result);
    }

    public static void calcular(FuncionTipoInt cal){

    }

    public static void calcular(FuncionTipoLong cal){

    }
}