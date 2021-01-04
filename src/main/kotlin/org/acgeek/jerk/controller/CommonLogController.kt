package org.acgeek.jerk.controller

import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import org.acgeek.jerk.database.CommonLogDo
import org.acgeek.jerk.logic.QueryAndPiece
import org.acgeek.jerk.repository.CommLogRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/log")
class CommonLogController(private val commLogRepository: CommLogRepository, private val logic: QueryAndPiece) {

    @GetMapping("")
    suspend fun index(): List<CommonLogDo> {
        return commLogRepository.findAll().drop(1).take(2).toList()
    }

    @GetMapping("/try")
    suspend fun tryMe(a: Long, b: Long): CommonLogDo? {
        return logic.getMaxFormTwo(a, b)
    }
}