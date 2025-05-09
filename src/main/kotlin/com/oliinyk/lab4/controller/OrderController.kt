package com.oliinyk.lab4.controller

import com.oliinyk.lab4.entity.OrderEntity
import com.oliinyk.lab4.svc.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping
    fun createOrder(@RequestBody order: OrderEntity): OrderEntity {
        return orderService.createOrder(order)
    }
}