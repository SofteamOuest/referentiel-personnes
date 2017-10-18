package com.softeam.referentielpersonnes.back.query

import com.softeam.referentielpersonnes.back.domain.Personne
import com.softeam.referentielpersonnes.back.repository.PersonneRepository
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

}