package com.oliinyk.lab4.svc

import com.oliinyk.lab4.dto.UserDTO
import com.oliinyk.lab4.entity.OrderEntity
import com.oliinyk.lab4.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val userClient: UserClient
) {

    fun createOrder(order: OrderEntity): OrderEntity {
        val user: UserDTO? = userClient.getUser(order.userId)

        return user?.let {
            orderRepository.save(order)
        } ?: throw RuntimeException("User not found")
    }
}