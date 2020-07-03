/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielle
 */
public class ConsultasDAO {
        
public void Insere(Consultas consultas){
 
 String sql = "INSERT INTO consultas(hora,data,motivo, valor, id_pet, id_vet, id_consultas)" +
 " VALUES(?,?,?,?,?,?,?)";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 pstm.setString(1, consultas.getHora());
 pstm.setString(2, consultas.getData());
 pstm.setString(3, consultas.getMotivo());
 pstm.setInt(4, consultas.getValor());
 pstm.setInt(5, consultas.getId_vet());
 pstm.setInt(6, consultas.getId_pet());
 pstm.setInt(7, consultas.getId_consultas());
 
 //Executa a sql para inserção dos dados
 pstm.execute();
 
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 //Fecha as conexões
 
 try{
 if(pstm != null){
  System.out.println("Registros inseridos!");
 pstm.close();
 }
 if(conn != null){
 conn.close();
 }
 }catch(Exception e){
 }}}



public void Update(Consultas consultas){
 
 String sql = "UPDATE consultas SET hora = ?, data = ?" + " WHERE id_consultas = ?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
 
 pstm.setString(1, consultas.getHora());
 pstm.setString(2, consultas.getData());
 pstm.setInt(3, consultas.getId_consultas());
 
 //Executa a sql para inserção dos dados
 pstm.execute();
 
 } catch (Exception e) {
 }finally{
 
 //Fecha as conexões
try{
 if(pstm != null){
 System.out.println("Registros modificados!");
 pstm.close();
 }
 if(conn != null){
 conn.close();
 }
 }catch(Exception e){
 }
 }
 }



public void DeleteById(int idcon){
 
 String sql = "DELETE FROM consultas WHERE id_consultas= ?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 conn = ConnectionFactory.createConnectionToMySQL();
 
 pstm = conn.prepareStatement(sql);
 
 pstm.setInt(1, idcon);
 
 pstm.execute();
 
 } catch (Exception e) {
 }finally{
 
 try{
 if(pstm != null){
 System.out.println("Consulta deletada!");
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }}
 catch(Exception e){
 }}}


public void ValorGanho(int id, String mot){

 String sql = "select SUM(valor)AS soma FROM consultas WHERE id_vet =? AND motivo=?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
 pstm = conn.prepareStatement(sql);
    
pstm.setInt(1,id);
pstm.setString(2,mot);

ResultSet res = pstm.executeQuery();
     int soma = 0;
 
while (res.next())
{
   double value = res.getDouble("soma");
   System.out.println("Valor total a ganhar com as consultas de "+mot+":" +'\n'+ +value +'\n');
}
 } catch (Exception e) {
 }finally{ 
 //Fecha as conexões
 try{
 if(pstm != null){
 pstm.close();
 }
 if(conn != null){
 conn.close();
 }
 }catch(Exception e){
 }

 }}
public void Agenda(int vet,String dia){

 String sql =  "select *FROM consultas WHERE id_vet =? AND data=?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
pstm = conn.prepareStatement(sql);
    
pstm.setInt(1,vet);
pstm.setString(2,dia);
ResultSet res = pstm.executeQuery();
String hora;
String data;
String motivo;
int valor;
int id_pet;
if (res.next()){ do {
hora = res.getString(1);
data = res.getString(2);
motivo = res.getString(3);
valor = res.getInt(4);
id_pet = res.getInt(5);
System.out.println ('\n'+"Hora:"+hora+"  Motivo:"+motivo+"  Valor:"+valor+"  Id do animal:"+id_pet);
this.Animal(id_pet);
}while (res.next());
} else {
         System.out.println ("Não há consultas marcadas para essa data.");
        }
 
 } catch (Exception e) {

 }finally{
 
 //Fecha as conexões
 try{
 if(pstm != null){
 pstm.close();
 }
 if(conn != null){
 conn.close();
 }
 }catch(Exception e){
 }}
}

public void Animal(int idpet){

 String sql =  "select *FROM cliente WHERE id_cliente =?";
 
 Connection conn = null;
 PreparedStatement pstm = null;
 
 try {
 //Cria uma conexão com o banco
 conn = ConnectionFactory.createConnectionToMySQL();
 
 //Cria um PreparedStatment, classe usada para executar a query
pstm = conn.prepareStatement(sql);
    
pstm.setInt(1,idpet);
ResultSet res = pstm.executeQuery();
String nome;
 
while (res.next())
{  
nome = res.getString(2);
System.out.println ("Nome do dono do animal:"+nome+'\n');

}
 } catch (Exception e) {
 }finally{
 
 //Fecha as conexões
 try{
 if(pstm != null){
 pstm.close();
 }
 if(conn != null){
 conn.close();
 }
 }catch(Exception e){
 }}}}