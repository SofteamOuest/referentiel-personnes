package com.softeam.referentielpersonnes.back.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class Personne(
        @Id
        var id: String? = null,
        var nom: String? = null
)