/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.Scanner;
/**
 *
 * @author danielle
 */
public class CRUD {
   
 
public static void main(String args[]) throws Exception{
 
 ConsultasDAO consultasDAO;
 consultasDAO = new ConsultasDAO();
 
 Scanner leitura= new Scanner (System.in);
 
//CRIA UMA CONSULTA E SALVA NO BANCO
  
 Consultas consultas = new Consultas();
 consultas.setHora("11:00");
 consultas.setData("26/09/2019");
 consultas.setMotivo("Banho");
 consultas.setValor((int) 40.00);
 consultas.setId_vet(3);
 consultas.setId_pet(1);
 consultas.setId_consultas(102);

 consultasDAO.Insere(consultas);
 
 
//ATUALIZA A CONSULTA 101 COM OS DADOS DA CONSULTA 1
 Consultas consultas1 = new Consultas();
 consultas1.setId_consultas(101);
 consultas1.setHora("15:00:00");
 consultas1.setData("30/10/2019");
 consultasDAO.Update(consultas1);

 //REMOVE UMA CONSULTA COM O ID DIGITADO;
 
System.out.print ("Digite o id da consulta a ser deletada: \n");
int idcon = leitura.nextInt();
consultasDAO.DeleteById(idcon);

}
}