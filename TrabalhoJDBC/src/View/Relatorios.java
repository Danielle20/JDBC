/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;
import DAO.ConsultasDAO;

/**
 *
 * @author danielle
 */
public class Relatorios {
    public static void main(String args[]) throws Exception{
        ConsultasDAO consultasDAO;
 consultasDAO = new ConsultasDAO();
 
Scanner leitura= new Scanner (System.in);

// MOSTRA O VALOR A RECEBER POR CONSULTAS DE ACORDO COM O VETERINARIO E O MOTIVO
System.out.print ("Digite o id do veterinario (1,2,3): \n");
int id = leitura.nextInt();
System.out.print ("Digite o motivo das consultas: (Vet1 = Cirurgia e Castração / Vet2 = Vacinação e Doença / Vet3 = Banho e Tosa )\n");
String mot = leitura.next();
consultasDAO.ValorGanho(id, mot);


// MOSTRA AS CONSULTAS MARCADAS PARA UM VETERINARIO EM UMA DATA
System.out.print ("Digite o id do veterinario(1,2,3): \n");
int vet = leitura.nextInt();
System.out.print ("Digite uma data (dd/MM/aaaa): \n");
String dia = leitura.next();
consultasDAO.Agenda(vet, dia);
  
    }}