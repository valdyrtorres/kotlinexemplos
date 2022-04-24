package com.valdir.bankaccount

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("accounts")
class AccountController(val repository: AccountRepository) {

    @PostMapping
    fun create(@RequestBody account: Account) : ResponseEntity<Account> = ResponseEntity.ok(repository.save(account))

    @GetMapping
    fun read() :ResponseEntity<List<Account>> = ResponseEntity.ok(repository.findAll())
    //fun read() :ResponseEntity<(Mutable)List<Account!>> = ResponseEntity.ok(repository.findAll())

    @PutMapping("{document}")
    fun update(@PathVariable document: String, @RequestBody account: Account): ResponseEntity<Account>{
        val accountDBOptional = repository.findByDocument(document)
        val toSave = accountDBOptional
                .orElseThrow{ RuntimeException("Account document: $document not found!") }
                .copy(name = account.name, balance = account.balance)
        return ResponseEntity.ok(repository.save(toSave))
    }

    @DeleteMapping("{document}")
    fun delete(@PathVariable document: String) = repository
        .findByDocument(document)
        .ifPresent{ repository.delete(it) }
}