package com.softeam.referentielpersonnes.back.query

import com.softeam.referentielpersonnes.back.domain.Personne
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class PersonnesQueryResource @Autowired constructor(
        private val personnesQueryService: PersonnesQueryService
) {

    private val logger = LoggerFactory.getLogger(PersonnesQueryResource::class.java)

    @RequestMapping(
            value = "/personnes/{id}",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun get(@PathVariable id: String): Personne? {
        logger.debug("Getting Personne #" + id)
        return personnesQueryService.get(id)
    }

    @RequestMapping(
            value = "/personnes",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    private fun list(pageable: Pageable): Iterable<Personne> {
        logger.debug("Getting all Personnes, " + pageable.toString())
        val list = personnesQueryService.list(pageable)
        logger.debug("List of Personnes " + list.content.toString())
        return list.content
    }

}