package com.softeam.referentielpersonnes.repository

import com.softeam.referentielpersonnes.domain.Personne
import org.springframework.data.mongodb.repository.MongoRepository

interface PersonneRepository : MongoRepository<Personne, String>