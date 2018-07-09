package com.softeam.referentielpersonnes.query

import com.softeam.referentielpersonnes.domain.Personne
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
            value = ["/personnes/{id}"],
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun get(@PathVariable id: String): Personne? {
        logger.info("Getting Personne #$id")
        return personnesQueryService.get(id)
    }

    @RequestMapping(
            value = ["/personnes"],
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    private fun list(pageable: Pageable): Iterable<Personne> {
        logger.info("Getting all Personnes, $pageable.toString()")
        val list = personnesQueryService.list(pageable)
        logger.debug("List of Personnes $list.content.toString()")
        return list.content
    }
    
    @PutMapping(path = arrayOf("/personnes/add"), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun ajouterPersonne(@RequestBody personne: Personne): Personne {
                    logger.info("ajouterPersonne new $personne.toString()")
                    return personnesQueryService.create(personne)
    }
	@RequestMapping(value = ["/personnes/delete/{id}"], method = arrayOf(RequestMethod.DELETE))
   fun supprimerPersonneById(@PathVariable id: String)  {
           logger.debug("C de Personnes $id")
       return personnesQueryService.delete(id)
  }

}