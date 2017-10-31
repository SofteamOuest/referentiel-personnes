package com.softeam.referentielpersonnes.dao.repository

import com.softeam.referentielpersonnes.dao.domain.Personne
import org.springframework.data.mongodb.repository.MongoRepository

interface PersonneRepository : MongoRepository<Personne, String>