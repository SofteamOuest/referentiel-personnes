package com.softeam.referentielpersonnes.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class Personne(
        @Id
        var id: String? = null,
        var nom: String? = null,
        var prenom: String? = null,
        var date_de_naissance: String? = null,
        var photo: String? = null,
        var mail_pro: String? = null,
        var mail_perso: String? = null,
        var role: String? = null,
        var tel_pro: String? = null,
        var tel_perso: String? = null,
        var poste: String? = null,
        var date_debut_contrat: String? = null,
        var date_visite_medical: String? = null,
        var periode_essai_valide: Boolean? = null
)