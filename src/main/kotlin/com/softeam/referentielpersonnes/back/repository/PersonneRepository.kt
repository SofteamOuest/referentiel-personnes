package com.softeam.referentielpersonnes.back.repository

import com.softeam.referentielpersonnes.back.domain.Personne
import org.springframework.data.mongodb.repository.MongoRepository

interface PersonneRepository : MongoRepository<Personne, String>