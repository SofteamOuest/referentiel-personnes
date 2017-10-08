package com.softeam.referentielpersonnes.back.command

import com.softeam.referentielpersonnes.back.domain.Personne
import com.softeam.referentielpersonnes.back.repository.PersonneRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PersonnesCommandService constructor(
        private val personneRepository: PersonneRepository
) {

    private val logger = LoggerFactory.getLogger(PersonnesCommandService::class.java)

    fun create(personne: Personne): Personne {
        logger.info("Saving new " + personne.toString())
        return personneRepository.save(personne)
    }

    fun update(personne: Personne): Personne {
        val oldPersonne: Personne? = personneRepository.findOne(personne.id)
        return if (oldPersonne != null) {
            logger.info("Updating " + oldPersonne.toString())
            logger.info("To " + personne.toString())
            personneRepository.save(personne)
        } else {
            personne
        }
    }

    fun delete(id: String) {
        val personne: Personne? = personneRepository.findOne(id)
        if (personne != null) {
            logger.info("Deleting " + personne.toString())
            personneRepository.delete(id)
        } else {
            logger.error("Could not find Personne #" + id)
        }
    }

}