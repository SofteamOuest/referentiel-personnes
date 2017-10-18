package com.softeam.referentielpersonnes.back.command

import com.softeam.referentielpersonnes.back.domain.Personne
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class PersonnesCommandResource @Autowired constructor(
        private val personnesCommandService: PersonnesCommandService
) {

    private val logger = LoggerFactory.getLogger(PersonnesCommandResource::class.java)

    @RequestMapping(
            value = "/personnes",
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun create(@RequestBody personne: Personne): Personne {
        logger.info("Received data for new $personne.toString()")
        return personnesCommandService.create(personne)
    }

    @RequestMapping(
            value = "/personnes",
            method = arrayOf(RequestMethod.PUT),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun update(@RequestBody personne: Personne): Personne {
        logger.info("Received data for updating $personne.toString()")
        return personnesCommandService.update(personne)
    }

    @RequestMapping(
            value = "/personnes/{id}",
            method = arrayOf(RequestMethod.DELETE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun delete(@PathVariable id: String) {
        logger.info("Deleting Personne #$id")
        personnesCommandService.delete(id)
    }

}