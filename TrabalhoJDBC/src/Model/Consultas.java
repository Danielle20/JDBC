/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Time;
import java.util.*;


/**
 *
 * @author danielle
 */
public class Consultas {
  private String hora;
  private String data;
  private String motivo;
  private int valor;
  private int id_pet;
  private int id_vet;
  public int id_consultas;

 
 public String getHora() {
 return hora;
 }
 
 public void setHora(String hora) {
 this.hora = hora;
 }
 
 public String getData() {
 return data;
 }
 
 public void setData(String data) {
 this.data = data;
 }
 
 public String getMotivo() {
 return motivo;
 }
 
 public void setMotivo(String motivo) {
 this.motivo = motivo;
 }
 
 public int getValor() {
 return valor;
 }
 
 public void setValor(int valor) {
 this.valor = valor;
 }
 public int getId_pet() {
 return id_pet;
 }
 
 public void setId_pet(int id_pet) {
 this.id_pet = id_pet;
 }
 public int getId_vet() {
 return id_vet;
 }
 
 public void setId_vet(int id_vet) {
 this.id_vet = id_vet;
 }

    void setId_consultas(int id_consultas) {  
 this.id_consultas = id_consultas;

     }
 
public int getId_consultas() {
 return id_consultas;
 }

   

}