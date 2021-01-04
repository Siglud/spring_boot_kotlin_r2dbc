package org.acgeek.jerk.repository

import org.acgeek.jerk.database.CommonLogDo
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CommLogRepository : CoroutineCrudRepository<CommonLogDo, Long> {
}