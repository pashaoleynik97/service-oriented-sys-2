package com.oliinyk.lab4.repository

import com.oliinyk.lab4.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, Long>