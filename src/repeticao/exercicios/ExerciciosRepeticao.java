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
//        restauranteUniversitario();
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
    static void restauranteUniversitario(){
        
        Scanner scanner = new Scanner(System.in);
        
//        Controle de sistema e contagem
        int totalAlunos = 0;
        int escolha;
        boolean continuar = true;
        
//        Contagem de grupos
        int menosQueDez = 0; // Grupo A
        int entreDezEQuinze = 0; // Grupo B
        int maisQueQuinze =0; // Grupo C
        
        System.out.println("--- Pesquisa Restaurante Universitario---");
        
        
//        Enquanto "continuar" continuar sendo verdadeiro ele vai rodar
        while (continuar){
        
            System.out.println("Qual das opcoes deseja seguir?");
            System.out.println("1- Registrar nova quantidade de vezes que voce foi ao restaurante");
            System.out.println("2- Mostrar porcentagem e finalizar o programa");
            
            
//            Parte do menu onde damos o input e ele verifica se tem um numero
            if (scanner.hasNextInt()){
                
                escolha = scanner.nextInt();
                
//                utilizada para limpar o buffer do enter que você deu para confirmar sua escolha
                scanner.nextLine();
                
            } else {
            
                System.out.println("Entrada inválida.");
                scanner.nextLine();
                continue; // pra continuar o loop
                
            }
            
//            Aqui é onde filtramos o que o usuario escolheu
//            Como 1 ou 2. Qualquer outra escolha dará um "erro"
            
            switch(escolha){
            
                case 1:
                    System.out.println("Quantas vezes voce visitou o restaurante universitario?");
                    
                    
//                    Verifica se é um numero inteiro
                    if (scanner.hasNextInt()){
                    
                        int vezesRestaurante = scanner.nextInt();
                        scanner.nextLine();
                        
                        totalAlunos++;     // Aqui adicionamos 1 ao total de alunos que participaram                   
                        
                        
//                        Aqui é parar separar o aluno em um dos 3 tipos de grupo que criei
                        if (vezesRestaurante < 10){
                            
//                            Grupo A com menos de 10 visitas
                            menosQueDez++;
                        
                        } else if (vezesRestaurante <= 15){
                        
//                            Grupo B ja sabemos que não é < que 10, logo, ele é >= 10
//                            agora so vemos se ele é <= a 15
                            entreDezEQuinze++;
                            
                        } else {
                        
//                            Grupo C entramos se não for nenhuma das 2 opções acima
//                            que é a mesma coisa que ele ser < que 15
                            maisQueQuinze++;
                            
                        }
                        
                    } else { 
                    
                        System.out.println("Quantidade invalida.");
                        scanner.nextLine();
                        
                    }
                    break;
            
                case 2: 
                    
                    System.out.println("---Programa finalizado---");
                    
                    
//                    Verifica se tem numeros para calcular 
                    if (totalAlunos == 0){
                    
                        System.out.println("Nenhum aluno foi entrevistado.");
                        
                    } else {
                        
//                        CALCULO FINAL
//                        (double) é para converter para double os ints ali dentro
//                        e não zerar. (ex: 0.3 -> 0)
                        
                        double porcA = (double) menosQueDez / totalAlunos * 100;
                        double porcB = (double) entreDezEQuinze / totalAlunos * 100;
                        double porcC = (double) maisQueQuinze / totalAlunos * 100;
                        
//                        Impressão dos resultados finais
                        System.out.println("Total de alunos entrevistados: " + totalAlunos);
                        System.out.println("a) Alunos com menos de 10 visitas: \n" + porcA + "%");
                        System.out.println("a) Alunos com 10 a 15 visitas: \n" + porcB + "%");
                        System.out.println("a) Alunos com mais de 15 visitas: \n" + porcC + "%");
                        
                    }
                    
                    continuar = false; //programa parar de funcionar
                    break;
                  
                    // caso escolham uma opção que não existe
                default:
                    
                    System.out.println("Opcao invalida. Apenas 1 ou 2 funciona.");
                    
                    break;
                    
            }
        } 
        scanner.close();
    }
}
