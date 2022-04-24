package com.valdir.auditoria.controllers

import com.valdir.auditoria.entities.Contact
import com.valdir.auditoria.repositories.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

@RestController
@RequestMapping("/contacts")
class ContactController {

    @Autowired
    lateinit var repository: ContactRepository

    @GetMapping
    fun index(): List<Contact> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Long): Contact {
        return repository.findById(id).orElseThrow{ EntityNotFoundException() }
    }

    @PostMapping
    fun create(@Valid @RequestBody contact: Contact): Contact {
        return repository.save(contact)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @Valid @RequestBody newContact: Contact): Contact {
        val contact = repository.findById(id).orElseThrow{ EntityNotFoundException() }

        contact.apply {
            this.nome = newContact.nome
            this.email = newContact.email
        }

        return repository.save(contact)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        val contact = repository.findById(id).orElseThrow{ EntityNotFoundException() }
        repository.delete(contact)
    }
}