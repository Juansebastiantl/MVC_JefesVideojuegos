package com.apirest.skills;

import java.util.List;
import java.util.Optional;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/v1/skills")
public class SkillsController {

  @Autowired
  SkillsRepository skillsRepository;
  
  @PostMapping
  public ResponseEntity<SkillsModel> crearSkill(@RequestBody SkillsModel skill) {

    try {
      SkillsModel _skill = skillsRepository.save(skill);
      return new ResponseEntity<SkillsModel>(_skill, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
  
  @GetMapping
  public ResponseEntity<SkillsModel> obtenerSkill() {

   return new ResponseEntity(skillsRepository.findAll(), HttpStatus.OK);

    }

  @GetMapping ("{productID}")
  public ResponseEntity<SkillsModel> obtenerSkillbyId(@PathVariable String productID) {

        Optional<SkillsModel> skills = skillsRepository.findById(productID);

        if(skills.isPresent()) {
          return new ResponseEntity<>(skills.get(), HttpStatus.OK);
        } else {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
  
   @GetMapping ("/tipos/{tipo}")
    public ResponseEntity<SkillsModel> obtenerSkillbyTipo(@PathVariable String tipo) {
  
      List<SkillsModel> skills = skillsRepository.findByTipo(tipo);
      return new ResponseEntity(skills, HttpStatus.OK);

      }
      
   @PutMapping("{productID}")
    public ResponseEntity<SkillsModel> actualizarSkill(@PathVariable String productID, @RequestBody SkillsModel skill){
      try {
      Optional<SkillsModel> skills = skillsRepository.findById(productID);
       if (skills.isPresent()) {
         SkillsModel model = skills.get();
         model.setNombre(skill.getNombre());
         model.setTipo(skill.getTipo());
         model.setDificultad(skill.getDificultad());
         return new ResponseEntity<>(skillsRepository.save(model), HttpStatus.OK);} 
         else {return new ResponseEntity<>(HttpStatus.NO_CONTENT);}           
          } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
              }
 
      }






}
