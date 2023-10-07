package com.apirest.skills;

import java.util.List;

import javax.management.Query;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillsRepository extends MongoRepository<SkillsModel, String> {
    //SkillsModel findByTipo(String tipo);
    List<SkillsModel> findByTipo(String tipo);
   

}
