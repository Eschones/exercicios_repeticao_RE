package repeticao.exercicios;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Raphael Esch
 */
public class ExerciciosRepeticao {

    public static void main(String[] args) {
//        valoresInteiros();
//        valorDesconto();
//        numerosPares();
    }
    
//    exercicio 1
    static void valoresInteiros(){
        
//        para poder gerar números aleatorios
        Random gerador = new Random();
        
        int valorTotal = 0; //necessário declarar que é 0 para que se possa ser feita a soma
        int totalNumeros = 51; // necessario botar um numero a mais por conta do zero
        
        System.out.println("50 numeros aleatorios, positivos ou negativos, serao gerados");
        
        for (int i = 0; i < 50; i++){
            
//            escolhe um numero aleatorio entre 0 e 100
            int escolheNumero = gerador.nextInt(totalNumeros);
            
//            decide se vai ser negativo ou positivo
            boolean positivoNegativo = gerador.nextBoolean();
            
            int numeroRandom;
            
            
//            if (positivoNegativo == false &&escolheNumero != 0)
            if (!positivoNegativo && escolheNumero != 0){
                
                numeroRandom = escolheNumero * -1; //numero fica negativo
                
            } else {
            
                numeroRandom = escolheNumero;
                
            }
            
//            armazena o numero gerado nesse momento para ser somado com o próximo
            valorTotal += numeroRandom;
            System.out.println("Numero " + (i + 1) + ": " + numeroRandom);
            
        }
        
        System.out.println("A soma total dos numeros eh: " + valorTotal);
        
    }
    
//    exercicio 2
    static void valorDesconto(){
        
        Scanner scanner = new Scanner(System.in);
        
        String nome;
        double valorCompra;
        double valorLoja = 0;
        double valorFinal;
        double desconto;
        double valorDescontado;       
        
        for (int i = 0; i < 10; i++){
        
            System.out.println("Qual seu nome?");
            nome = scanner.nextLine();
            
            System.out.println("Qual o valor da compra?");
            valorCompra = scanner.nextDouble();
            
            scanner.nextLine(); //necessario para que o \n seja "comido" e não atrapalhe a próxima execução
            
            if (valorCompra >= 250){
            
                desconto = 0.2;
                
            } else {
            
                desconto = 0.15;
                
            }
            
                valorDescontado = valorCompra * desconto;
                valorFinal = valorCompra - valorDescontado;
                valorLoja += valorFinal;
                
                System.out.println(nome + " " + valorCompra + " " + valorDescontado + " " + valorFinal);
        }
        
                System.out.println("A loja arrecadou um total de: " + valorLoja);
        
        scanner.close();
    }
    
//    exercicio 3
    static void numerosPares(){
        
        int valorTotal = 0;
        
        for (int i = 85; i <= 907; i++){
            
            if (i % 2 == 0){
                
                System.out.println(i);
                valorTotal += i;
                
                // poderia retirar totalmente o else daqui pois não há o que fazer com os impares
            } else { 
            }
        }
        
        System.out.println("A soma total dos numeros eh: " + valorTotal);
        
//        Abaixo deixei uma forma de "otimização" que o Gemini me deu quando perguntei se havia algo
//        que eu poderia melhorar.
//        
//        for (int i = 86; i <= 907; i += 2) {
//        // Não precisamos mais do IF, pois 'i' será sempre par
//        System.out.println(i);
//        valorTotal += i;
//    }
        
    }
    
//    exercicio 4
    
}
