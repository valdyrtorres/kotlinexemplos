package com.valdir.auditoria.entities

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "contacts")
class Contact {
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @field:NotNull
    @field:Size(min = 5, max = 50)
    var nome: String = "AAAAAAB"

    @field:NotNull
    @field:Email
    var email: String = "AAA"
}