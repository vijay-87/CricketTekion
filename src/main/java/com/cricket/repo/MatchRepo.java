package com.cricket.repo;

import com.cricket.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends MongoRepository<Match,String> {
}
