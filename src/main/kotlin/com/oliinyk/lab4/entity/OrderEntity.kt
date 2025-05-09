package com.oliinyk.lab4.entity

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = "orders")
@DynamicInsert
@DynamicUpdate
data class OrderEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userId: Long,

    val product: String,

    val quantity: Int
)