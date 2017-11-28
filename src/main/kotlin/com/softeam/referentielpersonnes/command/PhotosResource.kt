package com.softeam.referentielpersonnes.command


import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
class PhotosResource @Autowired constructor(
        private val photosService: PhotosService
) {

    private val logger = LoggerFactory.getLogger(PhotosResource::class.java)
    /**
     * Import des candidats d'une auto-école
     */
    @PostMapping(path = arrayOf("/photos/{id_personne}"), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun importer(@PathVariable(name = "id_personne") idPersonne: String,
                 @RequestParam("file") file: MultipartFile) {
         photosService.create(file,idPersonne)
    }

}