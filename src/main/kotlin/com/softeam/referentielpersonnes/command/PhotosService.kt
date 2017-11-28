package com.softeam.referentielpersonnes.command

import com.dropbox.core.v2.DbxClientV2Base
import com.softeam.referentielpersonnes.domain.Personne
import org.springframework.stereotype.Service
import com.softeam.referentielpersonnes.query.PersonnesQueryService
import org.springframework.web.multipart.MultipartFile



@Service
class PhotosService constructor(
        private val dbxClientV2Base: DbxClientV2Base,
        private val personnesQueryService: PersonnesQueryService
) {

    fun create(file: MultipartFile, idPersonne: String) {
        val personne  : Personne?
        personne = personnesQueryService.get(idPersonne);
        if(personne != null) {
            val nomFichier = "/" + personne.nom + "_" + personne.prenom + "_" + personne.date_de_naissance + ".jpg";
            val metadata = dbxClientV2Base.files().uploadBuilder(nomFichier)
                    .uploadAndFinish(file.inputStream)
        }
    }
}