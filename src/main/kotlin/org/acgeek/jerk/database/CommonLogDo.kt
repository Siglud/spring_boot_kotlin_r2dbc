package org.acgeek.jerk.database

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(value = "tb_common_log")
data class CommonLogDo(
        @Id
        val id:Long = 0,
        val playInstanceId: Long = 0,
        val shopId: Long = 0,
        val createdAt: LocalDateTime = LocalDateTime.MIN,
        val updatedAt: LocalDateTime = LocalDateTime.MIN,
        val createdBy: String = "",
        val updatedBy: String = "",
)
