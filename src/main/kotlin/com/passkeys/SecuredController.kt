package com.passkeys

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SecuredController {

    @GetMapping("/")
    fun securedEndpoint(): String {
        return "This is a secured endpoint"
    }

    @GetMapping("/admin")
    fun adminEndpoint(): String {
        return "This is an admin endpoint"
    }
}