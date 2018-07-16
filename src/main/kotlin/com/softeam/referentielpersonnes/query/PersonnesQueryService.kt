package com.softeam.referentielpersonnes.query

import com.softeam.referentielpersonnes.domain.Personne
import com.softeam.referentielpersonnes.repository.PersonneRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PersonnesQueryService constructor(
        private val personneRepository: PersonneRepository
) {

    fun get(id: String): Personne? {
        return personneRepository.findOne(id)
    }

    fun list(pageable: Pageable): Page<Personne> {
        return personneRepository.findAll(pageable)
    }
        fun create(personne: Personne): Personne {
        return personneRepository.save(personne)
    }
    
        fun update(personne: Personne): Personne {
        val oldPersonne: Personne? = personneRepository.findOne(personne.id)
        return if (oldPersonne != null) {
            personneRepository.save(personne)
        } else {
            personne
        }
    }
    
        fun delete(id: String) {
        val personne: Personne? = personneRepository.findOne(id)
        if (personne != null) {
            personneRepository.delete(id)
        }
    }

}