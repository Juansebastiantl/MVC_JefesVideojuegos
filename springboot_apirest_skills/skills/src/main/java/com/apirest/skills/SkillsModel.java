package com.apirest.skills;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="skills")
public class SkillsModel {

  @Id
  private String id;
  private String nombre;
  private String tipo;
  private Integer dificultad;

  public SkillsModel(String id, String nombre, String tipo, Integer dificultad) {
    this.id = id;
    this.nombre = nombre;
    this.tipo = tipo;
    this.dificultad = dificultad;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Integer getDificultad() {
    return dificultad;
  }

  public void setDificultad(Integer dificultad) {
    this.dificultad = dificultad;
  }
  
}
