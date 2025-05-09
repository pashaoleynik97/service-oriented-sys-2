package com.oliinyk.lab4.svc

import com.oliinyk.lab4.dto.UserDTO
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class UserClient(
    private val restTemplate: RestTemplate
) {
    fun getUser(userId: Long): UserDTO? {
        val url = "http://userservice:8081/users/$userId"
        return restTemplate.getForObject(url, UserDTO::class.java)
    }
}